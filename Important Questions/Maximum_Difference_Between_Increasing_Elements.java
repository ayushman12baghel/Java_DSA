public class Maximum_Difference_Between_Increasing_Elements {

    public static int maximumDifference(int[] nums) {
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ans = Math.max(ans, nums[j] - nums[i]);
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 7, 1, 5, 4 };
        System.out.println(maximumDifference(nums));
    }
}
