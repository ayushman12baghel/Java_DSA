import java.util.*;

public class Maximum_Sum_of_Distinct_Subarrays_with_Length_K {

    // Approach Using Sliding Window
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long sum = 0;
        long ans = 0;

        while (j < n) {
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (j - i + 1 == k) {
                if (map.size() == k) {
                    ans = Math.max(ans, sum);
                }
                sum -= nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }
}
