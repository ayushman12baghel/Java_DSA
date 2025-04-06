import java.util.*;

public class Largest_Divisible_Subset {

    // Approach 1 Using Backtracking T.L.E
    public static List<Integer> largestDivisibleSubset(int nums[]) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        solve(nums, result, 0, new ArrayList<>(), -1);

        return result;
    }

    public static void solve(int nums[], List<Integer> result, int i, List<Integer> temp, int prev) {
        if (i >= nums.length) {
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }

            return;
        }

        if (prev == -1 || nums[i] % prev == 0) {
            temp.add(nums[i]);
            solve(nums, result, i + 1, temp, nums[i]);
            temp.remove(temp.size() - 1);
        }

        solve(nums, result, i + 1, temp, prev);
    }

    // Approach 2 Using Longest Increasing Subsequence code
    public static List<Integer> largestDivisibleSubset2(int nums[]) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int prevIndex[] = new int[n];
        Arrays.fill(prevIndex, -1);
        int lastChosenIndex = 0;
        int maxLength = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
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
        int nums[] = { 1, 2, 4, 8 };

        System.out.println(largestDivisibleSubset(nums));
        System.out.println(largestDivisibleSubset2(nums));
    }
}
