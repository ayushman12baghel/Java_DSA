import java.util.*;

public class Number_of_Arithmetic_Triplets {

    // Approach 1 Using Brute Force
    public static int arithmeticTriplets2(int[] nums, int diff) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[j] - nums[i]) == diff && (nums[k] - nums[j]) == diff) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Approach 2 Using Binary Search O(nlogn)
    public static int arithmeticTriplets(int nums[], int diff) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            boolean x = binarySearch(Arrays.copyOfRange(nums, i + 1, n), nums[i] + diff);
            boolean y = binarySearch(Arrays.copyOfRange(nums, i + 2, n), nums[i] + 2 * diff);

            if (x && y) {
                count++;
            }
        }

        return count;
    }

    public static boolean binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    // Approach 3 Using HashSet O(n)
    public static int arithmeticTriplets3(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - diff) && set.contains(nums[i] - 2 * diff)) {
                count++;
            }

            set.add(nums[i]);
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 1, 4, 6, 7, 10 };
        int diff = 3;

        System.out.println(arithmeticTriplets(nums, diff));
        System.out.println(arithmeticTriplets2(nums, diff));
        System.out.println(arithmeticTriplets3(nums, diff));
    }
}
