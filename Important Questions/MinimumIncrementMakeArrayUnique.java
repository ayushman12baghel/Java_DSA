import java.util.*;

public class MinimumIncrementMakeArrayUnique {

    public static int minIncrementForUnique(int nums[]) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 1, 4, 2, 1 };

        System.out.println(minIncrementForUnique(nums));
    }
}
