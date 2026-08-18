//Approach 1 O(n^2)
class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] subarrayCounts = new int[51]; 

        for (int i = 0; i <= nums.length - k; i++) {
            boolean[] inCurrentWindow = new boolean[51];
            
            for (int j = i; j < i + k; j++) {
                inCurrentWindow[nums[j]] = true;
            }

            for (int x = 0; x <= 50; x++) {
                if (inCurrentWindow[x]) {
                    subarrayCounts[x]++;
                }
            }
        }

        for (int x = 50; x >= 0; x--) {
            if (subarrayCounts[x] == 1) {
                return x;
            }
        }

        return -1;
    }
}
