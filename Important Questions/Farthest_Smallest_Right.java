import java.util.*;

public class Farthest_Smallest_Right {

    // Approahc Using Binary Search O(nlogn)
    public static ArrayList<Integer> farMin(int[] nums) {
        int n = nums.length;

        int suffix[] = new int[n];
        suffix[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            int result = binarySearch(suffix, left, right, nums[i]);

            ans.add(result);
        }

        return ans;
    }

    public static int binarySearch(int nums[], int left, int right, int target) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 5, 1, 3, 2 };
        System.out.println(farMin(nums));
    }
}
