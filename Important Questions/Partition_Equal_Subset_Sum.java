public class Partition_Equal_Subset_Sum {

    public static boolean canPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        if (sum1 - sum2 == 0) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 5, 11, 5 };

        System.out.println(canPartition(arr));
    }
}
