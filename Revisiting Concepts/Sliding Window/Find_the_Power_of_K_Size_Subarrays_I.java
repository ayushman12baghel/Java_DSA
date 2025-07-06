import java.util.*;

public class Find_the_Power_of_K_Size_Subarrays_I {

    public static int[] resultsArray(int nums[], int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        Arrays.fill(ans, -1);
        int count = 1;

        for (int i = 1; i < k; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count == k) {
            ans[0] = nums[k - 1];
        }

        int i = 1;
        int j = k;

        while (j < n) {
            if (nums[j - 1] + 1 == nums[j]) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                ans[i] = nums[j];
            }

            i++;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;

        int ans[] = resultsArray(nums, k);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
