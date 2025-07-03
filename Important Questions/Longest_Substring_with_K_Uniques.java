import java.util.*;

public class Longest_Substring_with_K_Uniques {

    public static int longestKSubstr(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int ans = -1;

        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }

                i++;
            }

            if (map.size() == k) {
                ans = Math.max(ans, j - i + 1);
            }

            j++;
        }

        return ans;
    }

    public static void main(String args[]) {
        String str = "aabacbebebe";
        int k = 3;

        System.out.println(longestKSubstr(str, k));
    }
}
