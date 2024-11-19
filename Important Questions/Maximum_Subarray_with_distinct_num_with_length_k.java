import java.util.*;

public class Maximum_Subarray_with_distinct_num_with_length_k {

    public static long maximumSubarraySum(int nums[], int k) {
        long maxSum = 0;
        long currSum = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                currSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            currSum += nums[right];
            set.add(nums[right]);

            if (right - left + 1 == k) {
                maxSum = Math.max(currSum, maxSum);
                currSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }
}
