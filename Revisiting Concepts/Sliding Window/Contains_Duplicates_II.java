import java.util.*;

public class Contains_Duplicates_II {

    // Approach 1 Using HashMap
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;

        while (j < n) {
            if (map.containsKey(nums[j])) {
                int prevIndex = map.get(nums[j]);
                if (Math.abs(j - prevIndex) <= k) {
                    return true;
                }
                map.put(nums[j], j);
            } else {
                map.put(nums[j], j);
            }

            j++;
        }

        return false;
    }

    // Approach 2 Using Sliding Window and HashSet
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int j = 0;
        int i = 0;

        while (j < n) {
            if (Math.abs(i - j) > k) {
                set.remove(nums[i]);
                i++;
            }

            if (set.contains(nums[j])) {
                return true;
            }

            set.add(nums[j]);
            j++;
        }

        return false;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 1, 2, 3 };
        int k = 2;

        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicate2(nums, k));
    }
}
