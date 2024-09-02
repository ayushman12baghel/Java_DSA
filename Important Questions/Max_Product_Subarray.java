public class Max_Product_Subarray {
    public static int maxProduct(int nums[]) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }

    public static int maxProduct2(int nums[]) {
        int left = 1;
        int right = 1;
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left *= nums[i];
            right *= nums[nums.length - 1 - i];

            ans = Math.max(ans, Math.max(left, right));
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct2(nums));
    }
}
