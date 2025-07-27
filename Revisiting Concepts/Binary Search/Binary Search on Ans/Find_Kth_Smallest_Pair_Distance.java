import java.util.*;

public class Find_Kth_Smallest_Pair_Distance {

    // Approach 1 Brute Force O(n^2)
    public static int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int arr[] = new int[max - min + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                arr[d]++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            k -= arr[i];

            if (k <= 0) {
                return i;
            }
        }

        return -1;
    }

    // Approach 2 Optimal Sorting + BinarySearch + Sliding Window
    public static int smallestDistancePair2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int countPair = slidingWindowCount(nums, k, mid);

            if (countPair < k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    public static int slidingWindowCount(int nums[], int k, int difference) {
        int n = nums.length;
        int count = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            while (nums[j] - nums[i] > difference) {
                i++;
            }

            count += (j - i);
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 6, 1 };
        int k = 3;

        System.out.println(smallestDistancePair(nums, k));
        System.out.println(smallestDistancePair2(nums, k));
    }
}
