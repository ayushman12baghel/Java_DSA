public class Longest_Palindromic_Substring {

    public static String longestPalindromicSubstring(String str) {
        int n = str.length();
        boolean dp[][] = new boolean[n][n];
        String ans = "";

        // for single char palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans = str.substring(i, i + 1);
        }

        // for 2 char
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans = str.substring(i, i + 2);
            }
        }

        // for more than 2 chars
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans = str.substring(i, j + 1);
                }
            }
        }

        return ans;

    }

    public static String expandFromCentre(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(right) == str.charAt(left)) {
            left--;
            right++;
        }

        return str.substring(left + 1, right);
    }

    public static String longestPalindromicSubstring2(String str) {
        int n = str.length();
        if (n <= 1) {
            return str;
        }

        String ans = str.substring(0, 1);

        for (int i = 0; i < n; i++) {
            String odd = expandFromCentre(str, i, i);
            String even = expandFromCentre(str, i, i + 1);

            if (odd.length() > ans.length()) {
                ans = odd;
            }
            if (even.length() > ans.length()) {
                ans = even;
            }

        }

        return ans;
    }

    public static void main(String args[]) {
        String str = "babad";

        System.out.println(longestPalindromicSubstring(str));

        System.out.println(longestPalindromicSubstring2(str));
    }
}
