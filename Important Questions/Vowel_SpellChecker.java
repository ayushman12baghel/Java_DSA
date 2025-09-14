import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        Set<String> actual = new HashSet<>();
        HashMap<String, String> lower = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();

        for (String word : wordlist) {
            actual.add(word);

            String lowerCase = word.toLowerCase();
            lower.putIfAbsent(lowerCase, word);

            String deVowel = devowel(lowerCase);
            vowel.putIfAbsent(deVowel, word);
        }

        String ans[] = new String[n];
        int i = 0;

        for (String query : queries) {
            if (actual.contains(query)) {
                ans[i++] = query;
            } else {
                String lowerCase = query.toLowerCase();
                if (lower.containsKey(lowerCase)) {
                    ans[i++] = lower.get(lowerCase);
                } else {
                    String devowel = devowel(lowerCase);
                    ans[i++] = vowel.getOrDefault(devowel, "");
                }
            }
        }

        return ans;
    }

    public String devowel(String word) {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}