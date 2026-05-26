import java.util.*;

//Approach Using Prefix Counts O(n)
class Solution {
    int minToggle(int[] nums) {
        int totalOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        int ans = nums.length - totalOnes;
        ans = Math.min(ans, totalOnes);
        int currentOnes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentOnes++;
            }

            int currentZeros = i - currentOnes + 1;
            int rightZeros = nums.length - totalOnes - currentZeros;

            ans = Math.min(ans, currentOnes + rightZeros);
        }

        return ans;
    }
}