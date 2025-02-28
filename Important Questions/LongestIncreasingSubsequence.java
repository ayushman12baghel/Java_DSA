import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {

    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static int longestIncreasingSubsequence2(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int length = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            length = Math.max(length, dp[i]);
        }

        return length;
    }

    // Approach 3
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;

        for (int num : dp) {
            if (num > ans) {
                ans = num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };

        System.out.println(longestIncreasingSubsequence(arr));
        System.out.println(longestIncreasingSubsequence2(arr));
        System.out.println(lengthOfLIS(arr));
    }
}
