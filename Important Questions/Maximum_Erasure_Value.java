import java.util.*;

public class Maximum_Erasure_Value {

    // Approach 1 Sliding WIndow + HashMap
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            if (!map.containsKey(nums[j])) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                sum += nums[j];
            } else {
                while (map.containsKey(nums[j])) {
                    sum -= nums[i];
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                    }

                    i++;
                }

                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                sum += nums[j];
            }

            ans = Math.max(sum, ans);

            j++;
        }

        return ans;
    }

    // Approach 2 Using Set + Sliding Window
    public static int maximumUniqueSubarray2(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        while (j < n) {
            while (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];
            ans = Math.max(ans, sum);

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };

        System.out.println(maximumUniqueSubarray(nums));
        System.out.println(maximumUniqueSubarray2(nums));
    }
}
