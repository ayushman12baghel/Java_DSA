public class Maximum_Ascending_Subarray_Sum {

    public static int maxAscendingSum(int nums[]) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                max = Math.max(sum, max);
                sum = nums[i];
            }
        }

        return Math.max(max, sum);
    }

    public static void main(String args[]) {
        int nums[] = { 10, 20, 30, 5, 10, 50 };
        System.out.println(maxAscendingSum(nums));
    }
}
