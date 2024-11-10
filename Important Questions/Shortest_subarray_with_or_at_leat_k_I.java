public class Shortest_subarray_with_or_at_leat_k_I {

    public static int minSubarrayLength(int nums[], int k) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int or = 0;
            for (int j = i; j < nums.length; j++) {
                or |= nums[j];
                if (or >= k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 1, 8 };
        int k = 10;

        System.out.println(minSubarrayLength(nums, k));
    }
}
