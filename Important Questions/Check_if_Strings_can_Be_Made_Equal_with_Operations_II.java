import java.util.*;

// Approach O(n)
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                freq1[s1.charAt(i) - 'a']++;
                freq1[s2.charAt(i) - 'a']--;
            } else {
                freq2[s1.charAt(i) - 'a']++;
                freq2[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 || freq2[i] != 0) {
                return false;
            }
        }

        return true;
    }
}