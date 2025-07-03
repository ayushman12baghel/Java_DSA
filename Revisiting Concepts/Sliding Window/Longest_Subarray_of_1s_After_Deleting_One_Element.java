import java.util.*;

public class Longest_Subarray_of_1s_After_Deleting_One_Element {

    // Brute Force Approach T.L.E
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
                int length = 0;
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }
                    if (nums[j] == 1) {
                        length++;
                        maxLength = Math.max(length, maxLength);
                    } else {
                        length = 0;
                    }
                }
            }
        }

        return count == 0 ? n - 1 : maxLength;
    }

    // Approach 2 Using Sliding Window O(n)
    public static int longestSubarray2(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }

                i++;
            }

            maxLength = Math.max(j - i + 1, maxLength);
            j++;
        }

        return maxLength - 1;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };

        System.out.println(longestSubarray(nums));
        System.out.println(longestSubarray2(nums));
    }
}
