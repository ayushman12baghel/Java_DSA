import java.util.*;

public class Minimum_Operations_to_make_array_Values_equal_k {

    public static int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num != k) {
                set.add(num);
            }
        }

        return set.size();
    }

    public static void main(String args[]) {
        int nums[] = { 5, 2, 5, 4, 5 };
        int k = 2;

        System.out.println(minOperations(nums, k));
    }
}
