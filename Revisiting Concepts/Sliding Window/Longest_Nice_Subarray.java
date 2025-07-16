import java.util.*;

public class Longest_Nice_Subarray {

    // Approach 1 Good Brute Force O(n^2)
    public static int longestNiceSubarray(int nums[]) {
        int n = nums.length;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int mask = nums[i];
            for (int j = i + 1; j < n; j++) {
                if ((mask & nums[j]) != 0) {
                    break;
                }

                maxLength = Math.max(maxLength, j - i + 1);
                mask |= nums[j];
            }
        }

        return maxLength;
    }

    // Approach 2 Using Sliding Window O(n)
    public static int longestNiceSubarray2(int nums[]) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxLength = 1;
        int mask = 0;

        while (j < n) {
            while ((mask & nums[j]) != 0) {
                mask ^= nums[i];
                i++;
            }

            mask |= nums[j];
            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 8, 48, 10 };

        System.out.println(longestNiceSubarray(nums));

        System.out.println(longestNiceSubarray2(nums));
    }
}
