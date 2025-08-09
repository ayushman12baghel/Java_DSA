public class Maximum_Sum_Circular_Array {

    // Approach 1 Two-Pass Kadane's min and max algo O(n)
    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxElement = nums[0];
        boolean allNegative = true;

        for (int num : nums) {
            if (num >= 0) {
                allNegative = false;
            }

            total += num;
            maxElement = Math.max(maxElement, num);
        }

        if (allNegative) {
            return maxElement;
        }

        int minimum = kadaneMinimum(nums);
        int maximum = kadaneMaximum(nums);

        return Math.max(maximum, total - minimum);
    }

    public static int kadaneMinimum(int nums[]) {
        int minSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.min(currentSum + nums[i], nums[i]);
            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }

    public static int kadaneMaximum(int nums[]) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Approach 2 One-Pass Kadane's Algo
    public static int maxSubarraySumCircular2(int[] nums) {
        int total = 0;
        int maxElement = nums[0];
        int maxSum = 0;
        int minSum = 0;
        int currentSumMax = 0;
        int currentSumMin = 0;
        boolean allNegative = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                allNegative = false;
            }

            maxElement = Math.max(maxElement, nums[i]);
            total += nums[i];

            currentSumMin = Math.min(currentSumMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currentSumMin);

            currentSumMax = Math.max(currentSumMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSumMax);
        }

        return allNegative ? maxElement : Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {
        int nums[] = { 5, -3, 5 };

        System.out.println(maxSubarraySumCircular(nums));
        System.out.println(maxSubarraySumCircular2(nums));
    }
}
