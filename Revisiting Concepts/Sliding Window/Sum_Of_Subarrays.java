import java.util.*;

public class Sum_Of_Subarrays {

    // Approach 1 Brute Force O(n^2)
    public static int subarraySum(int nums[]) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                totalSum += currentSum;
            }
        }

        return totalSum;
    }

    // Approach 2 Optimal O(n)
    public static int subarraySum2(int nums[]) {
        int n = nums.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += (nums[i] * (i + 1) * (n - i)); // Using approach like a element will contribute in how many
                                                       // number of subarrays
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };

        System.out.println(subarraySum(nums));
        System.out.println(subarraySum2(nums));
    }
}
