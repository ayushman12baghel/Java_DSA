import java.util.*;

public class Count_Number_of_Fair_Pairs {

    // Using Two Pointers O(n*log(n))
    public static long countFairPairs(int nums[], int lower, int upper) {
        Arrays.sort(nums);

        long u = binarySearch(nums, upper);
        long l = binarySearch(nums, lower - 1);

        return u - l;
    }

    public static long binarySearch(int nums[], int target) {
        long pairs = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                pairs += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 1, 7, 4, 4, 5 };
        int lower = 3;
        int upper = 6;

        System.out.println(countFairPairs(nums, lower, upper));
    }
}
