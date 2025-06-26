import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int q = Integer.parseInt(parts[1]);

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = (row.charAt(j) == '*' ? 1 : 0);
            }
        }

        int[][] dp = new int[n + 1][n + 1];

        // Prefix sum dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                        - dp[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            String[] query = br.readLine().split(" ");
            int y1 = Integer.parseInt(query[0]);
            int x1 = Integer.parseInt(query[1]);
            int y2 = Integer.parseInt(query[2]);
            int x2 = Integer.parseInt(query[3]);

            int ans = dp[y2][x2]
                    - dp[y1 - 1][x2]
                    - dp[y2][x1 - 1]
                    + dp[y1 - 1][x1 - 1];

            sb.append(ans).append("\n");
        }

        out.print(sb);
        out.flush();
    }
}
