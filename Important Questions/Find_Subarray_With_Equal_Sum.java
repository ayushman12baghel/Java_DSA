import java.util.*;

public class Find_Subarray_With_Equal_Sum {

    public static boolean findSubarray(int nums[]) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }

        return false;
    }

    public static void main(String args[]) {
        int nums[] = { 4, 2, 4 };
        System.out.println(findSubarray(nums));
    }
}
