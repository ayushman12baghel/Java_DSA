import java.util.*;

public class Max_Sum_of_Digits_with_Equal_digit_Sum {

    // Approach 1 Using HashMap
    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int sum = getSum(num);

            if (map.containsKey(sum)) {
                ans = Math.max(num + map.get(sum), ans);
            }

            map.put(sum, Math.max(map.getOrDefault(sum, 0), num));
        }

        return ans;
    }

    public static int getSum(int ans) {
        int sum = 0;
        while (ans > 0) {
            sum += ans % 10;
            ans /= 10;
        }

        return sum;
    }

    // Approach 2 Using Array as Sum of Digits 10^9 is 81
    public static int maximumSum2(int[] nums) {
        int ans[] = new int[82];
        int max = -1;

        for (int num : nums) {
            int sum = getSum(num);
            if (ans[sum] != 0) {
                max = Math.max(max, ans[sum] + num);
            }

            ans[sum] = Math.max(ans[sum], num);
        }

        return max;
    }

    public static void main(String args[]) {
        int nums[] = { 18, 43, 36, 13, 7 };

        System.out.println(maximumSum(nums));
        System.out.println(maximumSum2(nums));
    }
}
