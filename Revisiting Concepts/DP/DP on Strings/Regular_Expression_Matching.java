public class Regular_Expression_Matching {

    // Doing Memoisation
    public static boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0, dp);
    }

    public static boolean solve(String str, String pattern, int i, int j, Boolean dp[][]) {
        if (j == pattern.length()) {
            return i == str.length();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean firstCharMatch = false;
        if (i < str.length() && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
            firstCharMatch = true;
        }

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            boolean notTake = solve(str, pattern, i, j + 2, dp);
            boolean take = firstCharMatch && solve(str, pattern, i + 1, j, dp);

            return dp[i][j] = take || notTake;
        }

        return dp[i][j] = firstCharMatch && solve(str, pattern, i + 1, j + 1, dp);
    }

    public static void main(String[] args) {
        String str = "ab";
        String pattern = ".*";

        System.out.println(isMatch(str, pattern));
    }
}
