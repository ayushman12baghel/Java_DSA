import java.util.*;

public class Longest_Subarray_With_Majority_Greater_Than_K {

    // Approach Using HashMap and Prefix Sum
    public static int longestSubarray(int nums[], int k) {
        int n = nums.length;
        int sum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// To handle subarrays starting from index 0

        for (int i = 0; i < n; i++) {
            if (nums[i] > k) {
                sum++;
            } else {
                sum--;
            }

            if (sum > 0) {
                maxLength = i + 1;// If the prefix sum is positive, it means the whole subarray from 0 to i is
                                  // valid.
            } else {
                if (map.containsKey(sum - 1)) {
                    maxLength = Math.max(maxLength, i - map.get(sum - 1));// If we’ve seen sum - 1 at some earlier index
                                                                          // j, that means between j+1 to i, the balance
                                                                          // increased by 1.
                }
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 1 };
        int k = 2;

        System.out.println(longestSubarray(nums, k));
    }
}
