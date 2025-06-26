import java.util.*;

public class Longest_Binary_Subsequence_Less_Than_or_Equal_to_K {

    // Approach 1
    public static int longestSubsequence(String s, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        return solve(s, k, 0, map);
    }

    public static int solve(String str, int k, int index, HashMap<String, Integer> map) {
        if (index >= str.length()) {
            return 0;
        }
        String key = index + " " + k;

        if (map.containsKey(key)) {
            return map.get(key);
        }
        int take = 0;
        int val = (int) ((str.charAt(index) - '0') * Math.pow(2, str.length() - index - 1));

        if (k - val >= 0) {
            take = 1 + solve(str, k - val, index + 1, map);
        }

        int notTake = solve(str, k, index + 1, map);

        int result = Math.max(take, notTake);
        map.put(key, result);

        return result;
    }

    // Approach 2
    public static int longestSubsequence2(String s, int k) {
        int length = 0;
        int powerValue = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                length++;
            } else if (powerValue <= k) {
                length++;
                k -= powerValue;
            }

            if (powerValue <= k) {
                powerValue *= 2;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String str = "1001010";
        int k = 5;

        System.out.println(longestSubsequence(str, k));
        System.out.println(longestSubsequence2(str, k));
    }
}
