public class Find_Peak_Element {

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int findPeak(int nums[], int left, int right) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[left];
        }
        if (nums.length == 2) {
            return (nums[left] >= nums[right] ? nums[left] : nums[right]);
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
            return nums[mid];
        }

        int output = -1;

        if (nums[mid] > nums[mid + 1]) {
            output = findPeak(nums, left, mid - 1);
        } else if (nums[mid] < nums[mid + 1]) {
            output = findPeak(nums, mid + 1, right);
        } else {
            int rightPeak = findPeak(nums, mid + 1, right);
            int leftPeak = findPeak(nums, left, mid - 1);

            output = Math.max(leftPeak, Math.max(rightPeak, output));
        }

        return output;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 1, 3, 5, 6, 4 };

        System.out.println(findPeakElement(nums));
        System.out.println(findPeak(nums, 0, nums.length));
    }
}
