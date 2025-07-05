public class Subarray_Product_Less_Than_K {

    // Using Sliding Window
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        long product = 1;

        while (j < n) {
            product *= nums[j];

            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }

            ans += (j - i + 1);

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 5, 2, 6 };
        int k = 100;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
