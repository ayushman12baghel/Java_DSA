public class Product_of_array_except_self {
    public static int[] ProductExceptSelf(int nums[]) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int result[] = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 4, 5, 2 };
        nums = ProductExceptSelf(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
