import java.util.*;

public class Count_The_Number_of_Fair_Pairs {

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long l = binarySearch(nums, lower - 1);
        long u = binarySearch(nums, upper);

        return u - l;
    }

    public static long binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        long pairs = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                pairs += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 7, 4, 4, 5 }, lower = 3, upper = 6;

        System.out.println(countFairPairs(nums, lower, upper));
    }
}
