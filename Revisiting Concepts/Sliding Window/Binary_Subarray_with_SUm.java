import java.util.*;

public class Binary_Subarray_with_SUm {

    // Using Sliding Window
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1 };
        int goal = 2;

        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
