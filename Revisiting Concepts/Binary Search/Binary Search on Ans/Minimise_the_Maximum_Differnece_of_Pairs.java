import java.util.*;

public class Minimise_the_Maximum_Differnece_of_Pairs {

    // Binary Search and Sorting
    public static int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, p, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int p, int diff) {
        int pairs = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= diff) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }

        return pairs >= p;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 1, 2, 7, 1, 3 };
        int pairs = 2;

        System.out.println(minimizeMax(nums, pairs));
    }
}
