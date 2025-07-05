import java.util.*;

public class Get_Equal_Substrings_within_Budget {

    // Approach 1 Using Sliding Window O(n)
    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int cost = 0;

        while (j < n) {
            cost = cost + (int) Math.abs((s.charAt(j) - 'a') - (t.charAt(j) - 'a'));

            while (cost > maxCost) {
                cost = cost - (int) Math.abs((s.charAt(i) - 'a') - (t.charAt(i) - 'a'));
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;

        System.out.println(equalSubstring(s, t, maxCost));
    }
}
