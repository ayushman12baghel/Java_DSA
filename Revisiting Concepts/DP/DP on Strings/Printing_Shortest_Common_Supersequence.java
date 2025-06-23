import java.util.*;

public class Printing_Shortest_Common_Supersequence {

    public static String shortestCommonSupersequence(String str1, String str2) {

        if (str1.length() == 0) {
            return str2;
        }
        if (str2.length() == 0) {
            return str1;
        }

        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        solve(str1, str2, 0, 0, dp);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else if (solve(str1, str2, i + 1, j, dp) > solve(str1, str2, i, j + 1, dp)) {
                sb.append(str2.charAt(j));
                j++;
            } else {
                sb.append(str1.charAt(i));
                i++;
            }
        }

        while (i < str1.length()) {
            sb.append(str1.charAt(i++));
        }

        while (j < str2.length()) {
            sb.append(str2.charAt(j++));
        }

        return sb.toString();
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i >= str1.length()) {
            return str2.length() - j;
        }
        if (j >= str2.length()) {
            return str1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + solve(str1, str2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(solve(str1, str2, i + 1, j, dp), solve(str1, str2, i, j + 1, dp));
        }
    }

    public static void main(String args[]) {
        String str1 = "abac", str2 = "cab";

        System.out.println(shortestCommonSupersequence(str1, str2));
    }
}
