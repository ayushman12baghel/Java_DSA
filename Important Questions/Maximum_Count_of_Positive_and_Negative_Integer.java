import java.util.*;
import java.util.function.IntPredicate;

public class Maximum_Count_of_Positive_and_Negative_Integer {

    // Approach 1 Using Brute Force O(n)
    public static int maximumCount(int[] nums) {
        int negative = 0;
        int positive = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive++;
            } else if (nums[i] < 0) {
                negative++;
            }
        }

        return Math.max(positive, negative);
    }

    // Approach 2 Using Java Stream O(n)
    // public int maximumCount(int[] nums) {
    // IntPredicate lambdaP=num->num>0;
    // IntPredicate lambdaN=num->num<0;
    // int positiveCount=(int)Arrays.stream(nums).filter(lambdaP).count();
    // int negativeCount=(int)Arrays.stream(nums).filter(lambdaN).count();

    // return Math.max(positiveCount,negativeCount);
    // }
    public static int maximumCount2(int[] nums) {
        int positiveCount = (int) Arrays.stream(nums).filter(num -> num > 0).count();
        int negativeCount = (int) Arrays.stream(nums).filter(num -> num < 0).count();

        return Math.max(positiveCount, negativeCount);
    }

    // Approach 3 Using Binary Search O(log(n))
    public static int maximumCount3(int[] nums) {
        int pos = countPositive(nums);
        int neg = countNegative(nums);

        return Math.max(pos, neg);
    }

    public static int countPositive(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result == -1 ? 0 : nums.length - result;
    }

    public static int countNegative(int nums[]) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result == -1 ? 0 : result + 1;
    }

    // Approach 3 Modified
    public static int maximumCoun4(int[] nums) {
        int pos = binarSearch(nums, 1);
        int neg = binarSearch(nums, 0);

        return Math.max(nums.length - pos, neg);
    }

    public static int binarSearch(int nums[], int target) {
        int result = nums.length;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { -3, -2, -1, 0, 0, 1, 2 };
        System.out.println(maximumCount(nums));
        System.out.println(maximumCount2(nums));
        System.out.println(maximumCount3(nums));
        System.out.println(maximumCoun4(nums));
    }
}
