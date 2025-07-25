public class Max_Circular_SUbarray_Sum {

    // Approach Using Kadane's Algo to find MaxSubarraySum and MinSubarraySum and
    // then can return totalSum-minSubarraySum or MaxSubarraySum
    // T.C O(n)
    public static int maxCircularSum(int nums[]) {
        int totalSum = 0;
        boolean allNeg = true;

        for (int num : nums) {
            totalSum += num;
            if (num >= 0) {
                allNeg = false;
            }
        }

        int maxSubarraySum = kadaneMax(nums);
        if (allNeg) {
            return maxSubarraySum;
        }

        int minSubarraySum = kadaneMin(nums);

        return Math.max(maxSubarraySum, totalSum - minSubarraySum);
    }

    public static int kadaneMax(int nums[]) {
        int maxSum = nums[0];
        int maxEnded = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnded = Math.max(nums[i], maxEnded + nums[i]);
            maxSum = Math.max(maxSum, maxEnded);
        }

        return maxSum;
    }

    public static int kadaneMin(int nums[]) {
        int minSum = nums[0];
        int minEnded = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minEnded = Math.min(nums[i], minEnded + nums[i]);
            minSum = Math.min(minSum, minEnded);
        }

        return minSum;
    }

    public static void main(String[] args) {
        int nums[] = { 8, -8, 9, -9, 10, -11, 12 };

        System.out.println(maxCircularSum(nums));
    }
}
