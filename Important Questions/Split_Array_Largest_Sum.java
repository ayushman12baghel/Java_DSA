import java.util.*;

// Using Binary Search on Ans -> O(Nlog(Sum(Nums)))
class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int left = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            left = Math.max(left, num);
        }
        System.out.print(left);

        int right = sum;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, mid, k)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int nums[], int maxLimit, int k) {
        int count = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum + nums[i] > maxLimit) {
                count++;
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
        }

        return count < k;
    }
}