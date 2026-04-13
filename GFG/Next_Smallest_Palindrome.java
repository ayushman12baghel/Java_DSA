import java.util.*;

// Approach O(n)
class Solution {
    static int[] nextPalindrome(int[] nums) {
        int n = nums.length;

        boolean all9 = true;

        for (int num : nums) {
            if (num != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int ans[] = new int[n + 1];
            ans[0] = 1;

            ans[n] = 1;
            return ans;
        }

        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0 ? mid : mid + 1);

        while (i >= 0 && nums[i] == nums[j]) {
            i--;
            j++;
        }

        boolean increaseMiddle = false;

        if (i < 0 || nums[i] < nums[j]) {
            increaseMiddle = true;
        }

        if (increaseMiddle) {
            int carry = 1;
            int current = (n - 1) / 2;

            while (carry > 0) {
                int sum = carry + nums[current];
                carry = sum / 10;
                nums[current] = sum % 10;
                current--;
            }
        }

        for (i = 0; i <= mid; i++) {
            nums[n - i - 1] = nums[i];
        }

        return nums;
    }
}