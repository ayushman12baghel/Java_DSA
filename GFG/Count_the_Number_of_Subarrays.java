import java.util.*;

//Approach Using Sliding Window O(n)
class Solution {
    long countSubarray(int N, int A[], long L, long R) {
        return solve(A, R) - solve(A, L - 1);
    }

    public long solve(int nums[], long target) {
        int n = nums.length;

        long sum = 0;
        long count = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            sum += nums[j];

            while (sum > target) {
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);

            j++;
        }

        return count;
    }
}