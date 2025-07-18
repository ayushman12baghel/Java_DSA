public class Single_Element_in_a_Sorted_Array {

    // Approach Binary Search
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isEvenAtRight = (n - mid) % 2 == 0 ? true : false;

            if (nums[mid] == nums[mid + 1]) {
                if (isEvenAtRight) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (isEvenAtRight) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate(nums));
    }
}
