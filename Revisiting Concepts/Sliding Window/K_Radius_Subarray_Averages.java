import java.util.Arrays;

public class K_Radius_Subarray_Averages {

    // Approach 1 Using Prefix Sum Array
    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return nums;
        }

        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        if (n < 2 * k + 1) {
            return ans;
        }

        long prefix[] = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = k; i < n - k; i++) {
            long sum = prefix[i + k];
            if (i - k - 1 >= 0) {
                sum -= prefix[i - k - 1];
            }
            ans[i] = (int) (sum / (2 * k + 1));
        }

        return ans;
    }

    // Approach 2 Using Sliding Window
    public static int[] getAverages2(int nums[], int k) {
        int n = nums.length;

        if (k == 0) {
            return nums;
        }

        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        if (n < 2 * k + 1) {
            return ans;
        }

        int left = 0;
        int right = 2 * k;
        long windowSum = 0;

        for (int i = left; i <= right; i++) {
            windowSum += nums[i];
        }

        int i = k;
        ans[i] = (int) (windowSum / (2 * k + 1));
        i++;
        right++;

        while (right < n) {
            int outWindow = nums[left];
            int inWindow = nums[right];
            windowSum = windowSum - outWindow + inWindow;
            ans[i] = (int) (windowSum / (2 * k + 1));

            right++;
            left++;
            i++;
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;

        int ans[] = getAverages(nums, k);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        int ans2[] = getAverages2(nums, k);
        for (int num : ans2) {
            System.out.print(num + " ");
        }
    }
}
