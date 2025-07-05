import java.util.*;

public class Count_Subarrays_Where_MaxElement_Appears_at_Least_K_Times {

    // Using Sliding Window O(n)
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int i = 0;
        int j = 0;
        int maxElement = 0;
        int maxCount = 0;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        while (j < n) {
            if (maxElement == nums[j]) {
                maxCount++;
            }

            while (maxCount >= k) {
                ans += (n - j);

                if (nums[i] == maxElement) {
                    maxCount--;
                }

                i++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 3, 3 };
        int k = 2;

        System.out.println(countSubarrays(nums, k));
    }
}
