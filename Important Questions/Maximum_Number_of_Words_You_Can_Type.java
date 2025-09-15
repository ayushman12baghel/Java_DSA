import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }

        String words[] = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean isPossible = true;

            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                count++;
            }
        }

        return count;
    }
}

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int broken[] = new int[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a']++;
        }

        int count = 0;
        boolean canType = true;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ') {
                canType = true;
                count++;
            } else if (broken[c - 'a'] > 0) {
                canType = false;
            }
        }

        if (canType) {
            count++;
        }

        return count;
    }
}