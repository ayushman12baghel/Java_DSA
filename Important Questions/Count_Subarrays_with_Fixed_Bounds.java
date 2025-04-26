public class Count_Subarrays_with_Fixed_Bounds {

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int maxkPosition = -1;
        int minkPosition = -1;
        int culpritIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                culpritIndex = i;
            }

            if (nums[i] == minK) {
                minkPosition = i;
            }

            if (nums[i] == maxK) {
                maxkPosition = i;
            }

            long smaller = Math.min(maxkPosition, minkPosition);
            long temp = smaller - culpritIndex;

            ans += (temp <= 0 ? 0 : temp);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 5, 2, 7, 5 };
        int minK = 1;
        int maxK = 5;

        System.out.println(countSubarrays(nums, minK, maxK));
    }
}
