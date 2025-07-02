import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate {

    // Using HashMap
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();

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

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1, 2, 3 };
        int k = 2;

        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
