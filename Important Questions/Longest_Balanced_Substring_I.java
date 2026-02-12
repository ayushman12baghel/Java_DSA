import java.util.*;

//Approach Brute Force O(n^2)
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int freq[] = new int[26];
            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                freq[c]++;
                boolean isPossible = true;

                for (int num : freq) {
                    if (num > 0 && num != freq[c]) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}