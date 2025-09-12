import java.util.*;

// Approach Greedy as Alice can win only if there is one vowel
class Solution {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                return true;
            }
        }

        return false;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}