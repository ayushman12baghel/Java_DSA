import java.util.*;

public class Count_Number_of_Nice_Subarrays {

    // Optimised Approach Using Sliding Window O(n)
    public static int numberOfSubarrays(int nums[], int k) {
        int n = nums.length;
        int oddCount = 0;
        int currentCount = 0;
        int maxCount = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            if (nums[j] % 2 != 0) {
                oddCount++;
                currentCount = 0;
            }

            while (oddCount == k) {
                currentCount++;

                if (nums[i] % 2 != 0) {
                    oddCount--;
                }

                i++;
            }

            maxCount += currentCount;

            j++;
        }

        return maxCount;
    }

    // Approach 2 Using PrefixSum and HashMap
    public static int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        int j = 0;

        while (j < n) {
            sum += (nums[j] % 2);

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 1, 1 };
        int k = 3;

        System.out.println(numberOfSubarrays(nums, k));
        System.out.println(numberOfSubarrays2(nums, k));
    }
}
