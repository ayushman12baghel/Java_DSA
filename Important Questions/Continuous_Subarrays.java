import java.util.*;

public class Continuous_Subarrays {

    public static long continuousSubarrays(int nums[]) {
        long count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.lastKey() - map.firstKey() > 2) {
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

    public static void main(String args[]) {
        int nums[] = { 5, 4, 2, 4 };

        System.out.println(continuousSubarrays(nums));
    }
}
