import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int freq[] = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] < 0) {
                return false;
            }
        }

        return true;
    }
}