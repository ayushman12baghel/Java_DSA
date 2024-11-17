public class Minimum_Size_Subarray_Sum {

    public static int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                size = Math.min(size, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));
    }
}
