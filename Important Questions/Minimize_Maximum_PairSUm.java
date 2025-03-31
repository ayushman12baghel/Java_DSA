import java.util.*;

public class Minimize_Maximum_PairSUm {

    public static int minPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            sum = Math.max(nums[left] + nums[right], sum);
            right--;
            left++;
        }

        return sum;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 5, 4, 2, 4, 6 };
        System.out.println(minPairSum(nums));
    }
}
