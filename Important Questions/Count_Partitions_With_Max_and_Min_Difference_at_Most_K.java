import java.util.*;

//Approach 1 Using Memoisation O(n^2) T.L.E
class Solution {
    int mod = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, k, dp);
    }

    public int solve(int nums[], int i, int k, int dp[]) {
        if (i >= nums.length) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ways = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int j = i; j < nums.length; j++) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);

            if (max - min > k) {
                break;
            }

            ways = (ways + solve(nums, j + 1, k, dp)) % mod;
        }

        return dp[i] = ways;
    }
}

// Approach 2 Tabulation O(n^2) T.L.E
class Solution {
    int mod = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int dp[] = new int[nums.length + 1];
        dp[nums.length] = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int ways = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (max - min > k) {
                    break;
                }

                ways = (ways + dp[j + 1]) % mod;
            }
            dp[i] = ways;
        }

        return dp[0];
    }
}

// Approach 3 Using DP + Sliding Window + PrefixSum O(n)
class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int mod = 1000000007;

        long dp[] = new long[n + 1];
        long prefix[] = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int i = 0;
        int j = 0;

        while (j < n) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                i++;
                while (maxDeque.peekFirst() < i) {
                    maxDeque.pollFirst();
                }
                while (minDeque.peekFirst() < i) {
                    minDeque.pollFirst();
                }
            }

            dp[j + 1] = (prefix[j] - (i > 0 ? prefix[i - 1] : 0) + mod) % mod;
            prefix[j + 1] = (prefix[j] + dp[j + 1]) % mod;

            j++;
        }

        return (int) dp[n];
    }
}