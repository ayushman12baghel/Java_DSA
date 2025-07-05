import java.util.*;

public class Length_of_Longest_Subarray_With_at_Most_K_Frequency {

    // Using Sliding Window and HashMap O(n)
    public static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1, 2, 3, 1, 2 };
        int k = 2;

        System.out.println(maxSubarrayLength(nums, k));
    }
}
