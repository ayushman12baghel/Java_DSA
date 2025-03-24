import java.util.*;

public class Subarray_Product_Less_Than_K {

    public static int numSubarrayProductLessThanK(int nums[], int k) {
        if (k == 0) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            product *= nums[j];

            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }

            count += (j - i + 1);
            j++;
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 10, 5, 2, 6 };
        int k = 100;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
