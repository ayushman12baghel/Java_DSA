public class Find_Min_in_ROtated_Sorted_Array {

    public static int findMin(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }

        return nums[left];
    }

    public static int findMax(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > right) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }
        return nums[left];
    }

    public static void main(String args[]) {
        int nums[] = { 3, 4, 5, 1, 2 };

        System.out.println(findMin(nums));
        // System.out.println(findMax(nums));
    }
}
