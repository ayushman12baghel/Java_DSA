import java.util.*;

public class Count_SUbarrays_with_Square_Less_Than_K {

    // Approach Sliding Window
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long sum = 0;
        long ans = 0;

        while (j < n) {
            sum += nums[j];

            while (i <= j && (sum * (j - i + 1)) >= k) {
                sum -= nums[i];
                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 4, 3, 5 };
        int k = 10;

        System.out.println(countSubarrays(nums, k));
    }
}
