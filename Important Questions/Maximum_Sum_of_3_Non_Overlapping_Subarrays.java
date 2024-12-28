import java.util.*;

public class Maximum_Sum_of_3_Non_Overlapping_Subarrays {

    static int dp[][];

    public static int[] maxSumOfThreeSubarrays(int nums[], int k) {
        int subarray[] = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int windowSum = 0;

        while (j < nums.length) {
            windowSum += nums[j];

            if (j - i + 1 == k) {
                subarray[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        dp = new int[subarray.length][4];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        solve(subarray, k, 0, 3, result);

        int ans[] = new int[3];
        i = 0;
        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }

    public static void solve(int subarray[], int k, int i, int count, List<Integer> result) {
        if (count == 0) {
            return;
        }
        if (i >= subarray.length) {
            return;
        }

        int take = subarray[i] + Helper(subarray, k, i + k, count - 1);
        int not_take = Helper(subarray, k, i + 1, count);

        if (take >= not_take) {
            result.add(i);
            solve(subarray, k, i + k, count - 1, result);
        } else {
            solve(subarray, k, i + 1, count, result);
        }
    }

    public static int Helper(int subarray[], int k, int i, int count) {
        if (count == 0) {
            return 0;
        }
        if (i >= subarray.length) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        int take = subarray[i] + Helper(subarray, k, i + k, count - 1);
        int not_take = Helper(subarray, k, i + 1, count);

        return dp[i][count] = Math.max(take, not_take);
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 1, 2, 6, 7, 5, 1 };
        int k = 2;

        int ans[] = maxSumOfThreeSubarrays(nums, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
