import java.util.*;

public class Sum_of_All_Subsets_XOR_Total {

    // Approach 1 O(2^n) By calculating SUbsets
    public static int subsetXORSum(int nums[]) {
        List<List<Integer>> subsets = new ArrayList<>();
        solve(nums, 0, subsets, new ArrayList<>());

        int sum = 0;

        for (List<Integer> subset : subsets) {
            int xor = 0;

            for (int num : subset) {
                xor ^= num;
            }

            sum += xor;
        }

        return sum;
    }

    public static void solve(int nums[], int i, List<List<Integer>> subsets, List<Integer> temp) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        solve(nums, i + 1, subsets, temp);
        temp.remove(temp.size() - 1);
        solve(nums, i + 1, subsets, temp);
    }

    // Approach 2 By calculating subsets and xor simultaneously
    public static int subsetXORSum2(int[] nums) {
        int subsets[] = new int[1];
        solve(nums, subsets, 0, 0);

        return subsets[0];
    }

    public static void solve(int nums[], int[] subsets, int i, int temp) {
        if (i == nums.length) {
            subsets[0] += temp;
            return;
        }
        solve(nums, subsets, i + 1, temp ^ nums[i]);
        solve(nums, subsets, i + 1, temp);
    }

    // Approach 3
    public static int subsetXORSum3(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum |= nums[i];
        }

        return sum << n - 1;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 4, 5, 6, 7, 8 };
        System.out.println(subsetXORSum(nums));
        System.out.println(subsetXORSum2(nums));
        System.out.println(subsetXORSum3(nums));
    }
}
