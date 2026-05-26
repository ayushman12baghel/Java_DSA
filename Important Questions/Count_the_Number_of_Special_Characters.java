import java.util.*;

//Approach O(n)
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean lower[] = new boolean[26];
        boolean upper[] = new boolean[26];
        int count = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
            } else {
                lower[c - 'a'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (upper[i] && lower[i]) {
                count++;
            }
        }

        return count;
    }
}