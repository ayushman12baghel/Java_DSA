import java.util.*;

public class Count_Complete_Subarray_in_an_Array {

    // Using Sliding Window
    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() >= set.size()) {
                count += (nums.length - j);
                int temp = nums[i];
                i++;
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) <= 0) {
                    map.remove(temp);
                }
            }

            j++;
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 1, 2, 2 };

        System.out.println(countCompleteSubarrays(nums));
    }
}
