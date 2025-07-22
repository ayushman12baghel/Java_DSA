import java.util.*;

public class Smallest_Positive_Misssing {

    public static int missingNumber(int nums[]) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (index == -1) {
            return 1;
        }

        int expected = 1;

        for (int i = index; i < nums.length; i++) {
            if (expected == nums[i]) {
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
                expected++;
            } else if (nums[i] > expected) {
                return expected;
            }
        }

        return expected;
    }

    public static void main(String[] args) {
        int nums[] = { 2, -3, 4, 1, 1, 7 };

        System.out.println(missingNumber(nums));
    }
}
