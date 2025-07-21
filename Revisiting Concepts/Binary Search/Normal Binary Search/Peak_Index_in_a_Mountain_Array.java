public class Peak_Index_in_a_Mountain_Array {

    // Approach Using Binary Search O(logn)
    public static int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 2, 1, 0 };

        System.out.println(peakIndexInMountainArray(nums));
    }
}
