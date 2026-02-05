import java.util.*;

//Approach 1 Using Memoisation O(n)
class Solution {
    public long maxSumTrionic(int[] nums) {
        long dp[][] = new long[nums.length][4];
        for (long row[] : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }

        return solve(nums, 0, 0, dp);
    }

    public long solve(int nums[], int index, int event, long dp[][]) {
        if (index >= nums.length) {
            return event == 3 ? 0 : Long.MIN_VALUE / 2;
        }

        if (dp[index][event] != Long.MIN_VALUE) {
            return dp[index][event];
        }

        long skip = Long.MIN_VALUE / 2;
        long take = Long.MIN_VALUE / 2;
        if (event == 0) {
            skip = solve(nums, index + 1, event, dp);
        }

        if (event == 3) {
            take = nums[index];
        }

        if (index + 1 < nums.length) {
            int current = nums[index];
            int next = nums[index + 1];

            if (event == 0 && current < next) {
                take = Math.max(solve(nums, index + 1, 1, dp) + current, take);
            } else if (event == 1) {
                if (current < next) {
                    take = Math.max(take, current + solve(nums, index + 1, 1, dp));
                } else if (current > next) {
                    take = Math.max(take, current + solve(nums, index + 1, 2, dp));
                }
            } else if (event == 2) {
                if (current < next) {
                    take = Math.max(take, current + solve(nums, index + 1, 3, dp));
                } else if (current > next) {
                    take = Math.max(take, current + solve(nums, index + 1, 2, dp));
                }
            } else if (event == 3 && current < next) {
                take = Math.max(take, current + solve(nums, index + 1, 3, dp));
            }
        }

        return dp[index][event] = Math.max(take, skip);
    }
}

// Approacch 2 Tabulation O(n)
class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long dp[][] = new long[n + 1][4];
        for (long row[] : dp) {
            Arrays.fill(row, Long.MIN_VALUE / 2);
        }

        dp[n][3] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int event = 0; event <= 3; event++) {
                long skip = Long.MIN_VALUE / 2;
                long take = Long.MIN_VALUE / 2;
                if (event == 0) {
                    skip = dp[i + 1][0];
                }

                if (event == 3) {
                    take = nums[i];
                }

                if (i + 1 < nums.length) {
                    int current = nums[i];
                    int next = nums[i + 1];

                    if (event == 0 && current < next) {
                        take = Math.max(dp[i + 1][1] + current, take);
                    } else if (event == 1) {
                        if (current < next) {
                            take = Math.max(take, current + dp[i + 1][1]);
                        } else if (current > next) {
                            take = Math.max(take, current + dp[i + 1][2]);
                        }
                    } else if (event == 2) {
                        if (current < next) {
                            take = Math.max(take, current + dp[i + 1][3]);
                        } else if (current > next) {
                            take = Math.max(take, current + dp[i + 1][2]);
                        }
                    } else if (event == 3 && current < next) {
                        take = Math.max(take, current + dp[i + 1][3]);
                    }
                }

                dp[i][event] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}