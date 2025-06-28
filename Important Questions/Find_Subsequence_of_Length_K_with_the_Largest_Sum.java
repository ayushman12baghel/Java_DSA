import java.util.Arrays;

public class Find_Subsequence_of_Length_K_with_the_Largest_Sum {

    public static int[] maxSubsequence(int[] nums, int k) {
        int arr[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        Arrays.sort(arr, 0, k, (a, b) -> a[0] - b[0]);

        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i][1];
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 1, 3, 3 };
        int k = 2;

        int ans[] = maxSubsequence(nums, k);

        for (int num : ans) {
            System.out.println(num);
        }
    }
}
