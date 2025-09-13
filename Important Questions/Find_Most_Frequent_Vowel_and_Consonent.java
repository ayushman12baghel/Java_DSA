import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        HashMap<Character, Integer> consMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consMap.put(c, consMap.getOrDefault(c, 0) + 1);
            }
        }

        int maxVowelCount = 0;
        int maxConsCount = 0;

        for (int value : vowelMap.values()) {
            maxVowelCount = Math.max(maxVowelCount, value);
        }

        for (int value : consMap.values()) {
            maxConsCount = Math.max(maxConsCount, value);
        }

        return maxVowelCount + maxConsCount;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}