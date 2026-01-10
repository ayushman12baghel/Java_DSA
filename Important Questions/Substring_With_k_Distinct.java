import java.util.*;

//Approach Using Sliding Window 
class Solution {
    public int countSubstr(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }

    public int atMost(String s, int k) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }

                i++;
            }

            count += (j - i);

            j++;
        }

        return count;
    }
}