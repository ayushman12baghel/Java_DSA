import java.util.*;

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

    // By Memoisation
    public static int lengthOfLIS2(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, -1, 0, dp);
    }

    public static int solve(int nums[], int prevIndex, int index, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int taken = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            taken = solve(nums, index, index + 1, dp) + 1;
        }
        int notTaken = solve(nums, prevIndex, index + 1, dp);

        return dp[index][prevIndex + 1] = Math.max(taken, notTaken);
    }

    // Printing The LIS
    public static void printLIS(int nums[]) {
        int dp[] = new int[nums.length];
        int parent[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLength = 1;
        int lisIndex = -1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;

                        if (maxLength < dp[i]) {
                            maxLength = dp[i];
                            lisIndex = i;
                        }
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lisIndex != -1) {
            result.add(nums[lisIndex]);
            lisIndex = parent[lisIndex];
        }

        Collections.reverse(result);

        System.out.println(result);
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };

        System.out.println(longestIncreasingSubsequence(arr));
        System.out.println(longestIncreasingSubsequence2(arr));
        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLIS2(arr));
        printLIS(arr);
    }
}
