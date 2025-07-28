import java.util.*;

public class Count_Number_of_Maximum_Bitwise_Or_Subsets {

    // Approach Recursion
    public static int countMaxOrSubsets(int[] nums) {
        int maxXor = 0;
        for (int num : nums) {
            maxXor |= num;
        }

        int count[] = new int[1];
        solve(nums, 0, count, maxXor, 0);

        return count[0];
    }

    public static void solve(int nums[], int index, int count[], int maxXor, int currentXor) {
        if (index >= nums.length) {
            if (maxXor == currentXor) {
                count[0]++;
            }

            return;
        }

        solve(nums, index + 1, count, maxXor, currentXor | nums[index]);
        solve(nums, index + 1, count, maxXor, currentXor);
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 1, 5 };
    }
}
