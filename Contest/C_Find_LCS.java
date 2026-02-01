package Contest;

import java.util.*;

public class C_Find_LCS {
    static int[][] dp;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int lcsLength = lcs(n - 1, m - 1);
        System.out.println(lcsLength);

        List<Integer> lcsSequence = new ArrayList<>();
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] == b[j]) {
                lcsSequence.add(a[i]);
                i--;
                j--;
            } else {
                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;
                if (up >= left) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        Collections.reverse(lcsSequence);
        for (int val : lcsSequence) {
            System.out.print(val + " ");
        }
    }

    static int lcs(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (a[i] == b[j]) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1);
        } else {
            return dp[i][j] = Math.max(lcs(i - 1, j), lcs(i, j - 1));
        }
    }
}
