import java.util.*;

public class Subarrays_With_SUm_K {

    // Approach Using HashMap O(n)
    public static int cntSubarrays(int nums[], int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        System.out.println(cntSubarrays(nums, k));
    }
}
