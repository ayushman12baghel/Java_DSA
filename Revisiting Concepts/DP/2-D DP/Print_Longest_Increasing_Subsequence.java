import java.util.*;

public class Print_Longest_Increasing_Subsequence {

    public static List<Integer> printLIS(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        int prevIndex[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1);
        int maxLength = 1;
        int lastChosenIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prevIndex[i] = j;
                    }

                    if (maxLength < dp[i]) {
                        maxLength = dp[i];
                        lastChosenIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastChosenIndex >= 0) {
            result.add(nums[lastChosenIndex]);
            lastChosenIndex = prevIndex[lastChosenIndex];
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

        System.out.println(printLIS(nums));
    }
}
