import java.util.*;

public class Patching_Array {

    // Greedy Approach O(max(nums.length,log(n)))
    public static int minPatches(int[] nums, int n) {
        int i = 0;
        long maxReach = 0;
        int patchCount = 0;

        while (maxReach < n) {
            if (i < nums.length && nums[i] <= maxReach + 1) {
                maxReach += nums[i];
                i++;
            } else {
                maxReach += (maxReach + 1);
                patchCount++;
            }
        }

        return patchCount;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 10 };
        int n = 20;

        System.out.println(minPatches(nums, n));
    }
}
