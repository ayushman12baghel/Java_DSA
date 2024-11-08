public class Maximum_xor_for_each_Query {

    public static int[] getMaximumXOR(int nums[], int maximumBits) {
        int n = nums.length;
        int ans[] = new int[n];
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        int mask = ((1 << maximumBits) - 1);

        for (int i = 0; i < n; i++) {
            int k = xor ^ mask;
            ans[i] = k;
            xor ^= nums[n - i - 1];
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 3, 4, 7 };
        int maximumBits = 3;

        int ans[] = getMaximumXOR(nums, maximumBits);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
