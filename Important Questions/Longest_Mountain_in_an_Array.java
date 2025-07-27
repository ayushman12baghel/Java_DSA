import java.util.*;

public class Longest_Mountain_in_an_Array {

    public static int longestMountain(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int i = 1;

        while (i < n - 1) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && nums[left - 1] < nums[left]) {
                    left--;
                }

                while (right < n - 1 && nums[right] > nums[right + 1]) {
                    right++;
                }

                maxLength = Math.max(maxLength, right - left + 1);

                i = right;
            } else {
                i++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 4, 7, 3, 2, 5 };

        System.out.println(longestMountain(nums));
    }
}
