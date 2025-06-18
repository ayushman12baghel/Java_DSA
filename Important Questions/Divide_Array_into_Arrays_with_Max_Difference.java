import java.util.*;

public class Divide_Array_into_Arrays_with_Max_Difference {

    public static int[][] divideArray(int nums[], int k) {
        Arrays.sort(nums);
        int ans[][] = new int[nums.length / 3][3];
        int j = 0;

        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[][] {};
            }

            ans[j++] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k = 2;

        int ans[][] = divideArray(nums, k);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}
