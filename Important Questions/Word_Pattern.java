import java.util.*;

//Approach Using HashMap O(n) 
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        int n = pattern.length();
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if ((map.containsKey(c) && !map.get(c).equals(words[i]))
                    || (map2.containsKey(words[i]) && map2.get(words[i]) != c)) {
                return false;
            } else {
                map.put(c, words[i]);
                map2.put(words[i], c);
            }
        }

        return true;
    }
}