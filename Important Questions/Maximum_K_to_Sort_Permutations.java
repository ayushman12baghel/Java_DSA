class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int K = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                K &= nums[i];
            }
        }

        return K == -1 ? 0 : K;
    }
}
