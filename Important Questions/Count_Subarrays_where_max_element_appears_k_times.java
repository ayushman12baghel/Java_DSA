import java.util.*;

public class Count_Subarrays_where_max_element_appears_k_times {

    public static long countSubarrays(int[] nums, int k) {
        int count = 0;
        long ans = 0;
        int max = 0;
        int i = 0;
        int j = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        while (j < nums.length) {
            if (max == nums[j]) {
                count++;
            }

            while (count == k) {
                ans += (nums.length - j);
                if (nums[i] == max) {
                    count--;
                }
                i++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 2, 3, 3 };
        int k = 2;

        System.out.println(countSubarrays(nums, k));
    }
}
