import java.util.*;

public class Largest_Divisible_Subset {

    // Approach 1 Using Memoisation
    public static List<Integer> largestDivisibleSubset(int nums[]) {
        int n = nums.length;
        Arrays.sort(nums);

        List<Integer> dp[][] = new ArrayList[n][n + 1];

        return solve(nums, 0, -1, dp);
    }

    public static List<Integer> solve(int nums[], int index, int prevIndex, List<Integer> dp[][]) {
        if (index >= nums.length) {
            return new ArrayList<>();
        }

        if (dp[index][prevIndex + 1] != null) {
            return dp[index][prevIndex + 1];
        }

        // Take
        List<Integer> take = new ArrayList<>();
        if (prevIndex == -1 || nums[index] % nums[prevIndex] == 0) {
            take.add(nums[index]);
            take.addAll(solve(nums, index + 1, index, dp));
        }

        // not Take
        List<Integer> notTake = solve(nums, index + 1, prevIndex, dp);

        List<Integer> result = (take.size() > notTake.size() ? take : notTake);

        return dp[index][prevIndex + 1] = result;
    }

    // Approach 2 Using Tabulation
    public static List<Integer> largestDivisibleSubset2(int nums[]) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int prevIndex[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1);

        int maxLength = 1;
        int lastChosenIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prevIndex[i] = j;
                    }

                    if (dp[i] > maxLength) {
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
        int nums[] = { 1, 2, 4, 8 };

        System.out.println(largestDivisibleSubset(nums));
        System.out.println(largestDivisibleSubset2(nums));
    }
}
