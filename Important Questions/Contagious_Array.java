import java.util.*;

public class Contagious_Array {

    // Approach 1 With extra space
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum[] = new int[nums.length];
        map.put(0, -1);
        prefixSum[0] = nums[0] == 0 ? -1 : 1;
        map.put(prefixSum[0], 0);
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(prefixSum[i])) {
                ans = Math.max(ans, i - map.get(prefixSum[i]));
            } else {
                map.put(prefixSum[i], i);
            }
        }

        return ans;
    }

    // Approach 2 Without extra space
    public static int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = nums[0] == 0 ? -1 : 1;
        map.put(prefixSum, 0);
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            prefixSum = prefixSum + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(prefixSum)) {
                ans = Math.max(ans, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        System.out.println(findMaxLength(nums));
        System.out.println(findMaxLength2(nums));
    }
}
