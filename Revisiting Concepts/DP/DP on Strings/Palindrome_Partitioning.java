import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    // Approach 1 Using Backtracking
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void solve(String str, int i, List<String> curr, List<List<String>> ans) {
        if (i >= str.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < str.length(); j++) {
            if (isPalindrome(str.substring(i, j + 1))) {
                curr.add(str.substring(i, j + 1));
                solve(str, j + 1, curr, ans);

                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2 Using BluePrint to compute Palindrome
    public static List<List<String>> partition2(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        boolean dp[][] = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;

                if (i >= j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        solve(s, 0, new ArrayList<>(), ans, dp);

        return ans;
    }

    public static void solve(String str, int i, List<String> curr, List<List<String>> ans, boolean dp[][]) {
        if (i >= str.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < str.length(); j++) {
            if (dp[i][j]) {
                dp[i][j] = true;
                curr.add(str.substring(i, j + 1));
                solve(str, j + 1, curr, ans, dp);

                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";

        System.out.println(partition(str));
        System.out.println(partition2(str));
    }
}
