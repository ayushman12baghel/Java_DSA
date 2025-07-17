import java.util.*;

public class Count_the_Number_of_Good_Subarrays {

    public static long countGood(int nums[], int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long count = 0;
        long ans = 0;

        while (j < n) {
            if (map.containsKey(nums[j])) {
                count += map.get(nums[j]);
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            } else {
                map.put(nums[j], 1);
            }

            while (count >= k) {
                ans += (n - j);
                map.put(nums[i], map.get(nums[i]) - 1);
                count -= map.get(nums[i]);
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
        int nums[] = { 3, 1, 4, 3, 2, 2, 4 };
        int k = 2;

        System.out.println(countGood(nums, k));
    }
}
