import java.util.*;

public class Find_the_number_of_Fair_Pairs {

    // Approach 1
    public static long findFairPairs(int nums[], int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long result = 0;

        for (int i = 0; i < n; i++) {
            int lowerBound = lowerBound(nums, i + 1, n, lower - nums[i]);
            int upperBound = upperBound(nums, i + 1, n, upper - nums[i]);
            int x = lowerBound - i - 1;
            int y = upperBound - i - 1;
            result += (y - x);
        }

        return result;
    }

    public static int lowerBound(int nums[], int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int upperBound(int nums[], int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Approach 2
    public static long findFairPairs2(int nums[], int lower, int upper) {
        Arrays.sort(nums);
        long lowerX = countPairs(nums, lower - 1);
        long upperY = countPairs(nums, upper);

        return upperY - lowerX;
    }

    public static long countPairs(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        long pairs = 0;

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

    public static void main(String[] args) {
        int nums[] = { 0, 1, 7, 4, 4, 5 };
        int lower = 3, upper = 6;

        System.out.println(findFairPairs(nums, lower, upper));

        System.out.println(findFairPairs2(nums, lower, upper));
    }
}
