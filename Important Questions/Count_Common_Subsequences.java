
// You are using Java
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int lcs = lcs(str1, str2);

        System.out.println(lcs);
    }

    public static int lcs(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(str1, str2, 0, 0, dp);
    }

    public static int solve(String str1, String str2, int i, int j, int dp[][]) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = 1 + solve(str1, str2, i + 1, j, dp) + solve(str1, str2, i, j + 1, dp);
        } else {
            return dp[i][j] = solve(str1, str2, i + 1, j, dp) + solve(str1, str2, i, j + 1, dp)
                    - solve(str1, str2, i + 1, j + 1, dp);
        }
    }
}