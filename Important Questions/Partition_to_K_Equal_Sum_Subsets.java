import java.util.*;

public class Partition_to_K_Equal_Sum_Subsets {

    public static void reverse(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static boolean canPartition(int start, int nums[], boolean vis[], int k, int currSum, int target) {
        if (k == 1) {
            return true;
        }
        if (currSum == target) {
            return canPartition(0, nums, vis, k - 1, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (vis[i] || currSum + nums[i] > target) {
                continue;
            }

            vis[i] = true;

            if (canPartition(i + 1, nums, vis, k, currSum + nums[i], target)) {
                return true;
            }

            vis[i] = false;
        }

        return false;
    }

    public static boolean canPartitionSubsets(int nums[], int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean vis[] = new boolean[n];

        Arrays.sort(nums);
        reverse(nums);

        return canPartition(0, nums, vis, k, 0, target);
    }

    public static void main(String[] args) {
        int nums[] = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;

        System.out.println(canPartitionSubsets(nums, k));
    }
}
