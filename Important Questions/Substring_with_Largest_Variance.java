import java.util.*;

//O(26*26*n)
class Solution {
    public int largestVariance(String s) {
        int n = s.length();

        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxVariance = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[i] == 0 || freq[j] == 0) {
                    continue;
                }

                char major = (char) (i + 'a');
                char minor = (char) (j + 'a');
                int majorCount = 0;
                int minorCount = 0;
                int remainMinor = freq[j];

                for (char c : s.toCharArray()) {
                    if (c == major) {
                        majorCount++;
                    } else if (c == minor) {
                        minorCount++;
                        remainMinor--;
                    }

                    if (minorCount > 0) {
                        maxVariance = Math.max(maxVariance, majorCount - minorCount);
                    }

                    if (minorCount > majorCount && remainMinor > 0) {
                        minorCount = 0;
                        majorCount = 0;
                    }
                }
            }
        }

        return maxVariance;
    }
}