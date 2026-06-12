import java.util.*;

// O(n)
class Solution {
    public boolean kSubstr(String s, int k) {
        if (s.length() % k != 0) {
            return false;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i += k) {
            String string = s.substring(i, i + k);
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        if (map.size() > 2) {
            return false;
        }
        if (map.size() == 1) {
            return true;
        }

        int minCount = Integer.MAX_VALUE;
        for (int num : map.values()) {
            minCount = Math.min(minCount, num);
        }

        return minCount <= 1;
    }
}