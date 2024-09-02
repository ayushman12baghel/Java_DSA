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
        int nums2[] = { 1, 4, 5, 2 };
        nums = ProductExceptSelf(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        nums2 = productExceptSelf(nums2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    public static int[] productExceptSelf(int nums[]) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int result[] = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;

    }
}
