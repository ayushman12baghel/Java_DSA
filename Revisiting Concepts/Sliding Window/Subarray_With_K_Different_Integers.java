import java.util.*;

public class Subarray_With_K_Different_Integers {

    // Approach 1 Using 2 Pass Sliding Window O(n)
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }

    public static int slidingWindow(int nums[], int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            count += (j - i + 1);

            j++;
        }

        return count;
    }

    // Approach 2 Using 1 Pass
    public static int subarraysWithKDistinct2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i_chota = 0;
        int j = 0;
        int i_bada = 0;
        int result = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
                map.put(nums[i_chota], map.get(nums[i_chota]) - 1);
                if (map.get(nums[i_chota]) == 0) {
                    map.remove(nums[i_chota]);
                }

                i_chota++;
                i_bada = i_chota;
            }

            while (map.get(nums[i_chota]) > 1) {
                map.put(nums[i_chota], map.get(nums[i_chota]) - 1);
                i_chota++;
            }

            if (map.size() == k) {
                result += (i_chota - i_bada + 1);
            }

            j++;
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 1, 3, 4 };
        int k = 3;

        System.out.println(subarraysWithKDistinct(nums, k));
        System.out.println(subarraysWithKDistinct2(nums, k));
    }
}
