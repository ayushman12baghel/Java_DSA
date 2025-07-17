import java.util.*;

public class Count_Complete_Subarrays_in_an_Array {

    // Approach Sliding Window
    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int k = set.size();
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() == k) {
                ans += (n - j);
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 1, 2, 2 };

        System.out.println(countCompleteSubarrays(nums));
    }

}
