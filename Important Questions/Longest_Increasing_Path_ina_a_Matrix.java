public class Longest_Increasing_Path_ina_a_Matrix {
    static int dp[][];

    public static int dfs(int matrix[][], int i, int j, int prevVal) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || prevVal >= matrix[i][j]) {
            return 0;
        }

        int temp = 0;
        int curr = matrix[i][j];

        temp = Math.max(dfs(matrix, i + 1, j, curr), temp);
        temp = Math.max(dfs(matrix, i - 1, j, curr), temp);
        temp = Math.max(dfs(matrix, i, j + 1, curr), temp);
        temp = Math.max(dfs(matrix, i, j - 1, curr), temp);

        return dp[i][j] = ++temp;
    }

    public static int longestIncreasingPath(int matrix[][]) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };

        System.out.println(longestIncreasingPath(matrix));
    }
}
