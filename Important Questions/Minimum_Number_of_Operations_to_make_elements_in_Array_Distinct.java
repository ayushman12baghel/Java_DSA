import java.util.*;

public class Minimum_Number_of_Operations_to_make_elements_in_Array_Distinct {

    // Approach 1 O(n^2)
    public static int minimumOperations(int nums[]) {
        int result = 0;

        for (int i = 0; i < nums.length; i += 3) {
            if (check(nums, i)) {
                return result;
            }

            result++;
        }

        return result;
    }

    public static boolean check(int nums[], int start) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            }

            set.add(nums[i]);
        }

        return true;
    }

    // Approach 2 Reverse Traversing
    public static int minimumOperations2(int nums[]) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                result = i / 3 + 1;
                return result;
            }

            set.add(nums[i]);
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 2, 3, 3, 5, 7 };

        System.out.println(minimumOperations(nums));
        System.out.println(minimumOperations2(nums));
    }
}
