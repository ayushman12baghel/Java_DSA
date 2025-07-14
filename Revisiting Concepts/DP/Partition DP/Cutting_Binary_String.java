import java.util.*;

public class Cutting_Binary_String {

    // Approach 1 Partition DP Memoisation

    static Set<String> powerOf5;

    public static int cuts(String s) {
        powerOf5 = new HashSet<>();
        preComputePower();

        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        int result = solve(s, 0, dp);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int solve(String s, int index, int dp[]) {
        if (index >= s.length()) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minCuts = Integer.MAX_VALUE;

        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);

            if (!sub.startsWith("0") && powerOf5.contains(sub)) {
                int nextCuts = solve(s, i, dp);

                if (nextCuts != Integer.MAX_VALUE) {
                    minCuts = Math.min(minCuts, nextCuts + 1);
                }
            }
        }

        return dp[index] = minCuts;
    }

    public static void preComputePower() {
        long val = 1;

        while (true) {
            String bin = Long.toBinaryString(val);
            if (bin.length() > 30) {
                break;
            }
            powerOf5.add(bin);
            val *= 5;
        }
    }

    // Approach 2 Tabulation
    Set<String> powerOf5;

    public int cuts(String s) {
        int n = s.length();
        powerOf5 = new HashSet<>();
        preComputePower();

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);

                if (!sub.startsWith("0") && powerOf5.contains(sub)) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public void preComputePower() {
        long val = 1;

        while (true) {
            String bin = Long.toBinaryString(val);
            if (bin.length() > 30) {
                break;
            }
            powerOf5.add(bin);
            val *= 5;
        }
    }

    public static void main(String[] args) {
        String s = "101101101";
        System.out.println(cuts(s));
    }
}
