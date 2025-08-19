import java.util.*;

public class Number_of_Zero_Filled_Arrays {

    public static long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
                ans += zeros;
            } else {
                zeros = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums));
    }
}
