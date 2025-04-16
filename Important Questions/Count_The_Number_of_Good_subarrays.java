import java.util.*;

public class Count_The_Number_of_Good_subarrays {

    // Sliding Window
    public static long countGood(int nums[], int k) {
        int n = nums.length;
        long result = 0;
        long pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        while (j < n) {
            pairs += map.getOrDefault(nums[j], 0);
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (pairs >= k) {
                result += (n - j);
                map.put(nums[i], map.get(nums[i]) - 1);
                pairs -= map.get(nums[i]);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 1, 4, 3, 2, 2, 4 };
        int k = 2;

        System.out.println(countGood(nums, k));
    }
}
