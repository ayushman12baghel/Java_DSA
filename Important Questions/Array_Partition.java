import java.util.*;

public class Array_Partition {

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String args[]) {
        int nums[] = { 6, 2, 6, 5, 1, 2 };
        System.out.println(arrayPairSum(nums));
    }
}
