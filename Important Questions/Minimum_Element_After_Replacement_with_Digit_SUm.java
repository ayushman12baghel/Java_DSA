class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            minSum = Math.min(minSum, getSum(num));
        }

        return minSum;
    }

    public int getSum(int num) {
        int sum = 0;

        while (num > 0) {
            int ld = num % 10;
            sum += ld;
            num /= 10;
        }

        return sum;
    }
}