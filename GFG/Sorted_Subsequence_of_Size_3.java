import java.util.*;

// Approach O(n)
class Solution {
    public ArrayList<Integer> find3Numbers(int[] nums) {
        int n = nums.length;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = nums[i];

            if (temp <= first) {
                first = temp;
            } else if (temp <= second) {
                second = temp;
                prev = first;
            } else {
                return new ArrayList<>(Arrays.asList(prev, second, temp));
            }
        }

        return new ArrayList<>();
    }
}