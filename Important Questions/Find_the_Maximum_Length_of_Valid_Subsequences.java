import java.util.*;

public class Find_the_Maximum_Length_of_Valid_Subsequences {

    // Approach 1 Brute Force Doing Memoisation M.L.E
    public static int maximumLength(int[] nums) {
        int odd = 0;
        int even = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int dp[][] = new int[nums.length][nums.length + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int alternating = solve(nums, 0, -1, dp);

        return Math.max(odd, Math.max(even, alternating));
    }

    public static int solve(int nums[], int index, int prevIndex, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int take = 0;
        if (prevIndex == -1 || (nums[index] % 2 != nums[prevIndex] % 2)) {
            take = 1 + solve(nums, index + 1, index, dp);
        }

        int notTake = solve(nums, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    // Tabulation T.L.E
    public static int maximumLength2(int[] nums) {
        int odd = 0;
        int even = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int alternating = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % 2 != nums[j] % 2) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    alternating = Math.max(alternating, dp[i]);
                }
            }
        }

        return Math.max(odd, Math.max(even, alternating));
    }

    // Approach 2 Optimised Approach
    public static int maximumLength3(int[] nums) {
        int odd = 0;
        int even = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int alternating = 1;
        int prevParity = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != prevParity) {
                alternating++;
                prevParity = nums[i] % 2;
            }
        }

        return Math.max(odd, Math.max(even, alternating));
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };

        System.out.println(maximumLength(nums));
    }
}
