import java.util.*;

//O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char fromS = s.charAt(i);
            char fromT = t.charAt(i);

            if ((map1.containsKey(fromS) && map1.get(fromS) != fromT)
                    || (map2.containsKey(fromT) && map2.get(fromT) != fromS)) {
                return false;
            }

            map1.put(fromS, fromT);
            map2.put(fromT, fromS);
        }

        return true;
    }
}