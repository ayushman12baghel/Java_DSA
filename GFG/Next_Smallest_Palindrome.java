import java.util.*;

// Approach O(n)
class Solution {
    Vector<Integer> generateNextPalindrome(int nums[], int n) {
        boolean all9 = true;
        Vector<Integer> ans = new Vector<>();

        for (int num : nums) {
            if (num != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) { // Case 1 All 9
            ans.add(1);
            for (int i = 0; i < n - 1; i++) {
                ans.add(0);
            }

            ans.add(1);

            return ans;
        }

        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0 ? mid : mid + 1);

        // Get the first missmatch
        while (i >= 0 && nums[i] == nums[j]) {
            i--;
            j++;
        }

        boolean leftSmaller = false;

        if (i < 0 || nums[i] < nums[j]) {
            leftSmaller = true;
        }

        // if leftSmaller or already a palindrome increment the middle
        if (leftSmaller) {
            int current = (n - 1) / 2;
            int carry = 1;

            while (current >= 0 && carry > 0) {
                int sum = nums[current] + carry;
                carry = sum / 10;
                nums[current] = sum % 10;
                current--;
            }
        }

        for (int k = 0; k <= (n - 1) / 2; k++) {
            nums[n - k - 1] = nums[k];
        }

        for (int num : nums) {
            ans.add(num);
        }

        return ans;
    }
}