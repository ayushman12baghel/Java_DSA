import java.util.*;

public class Rotate_Array {

    // Approach 1 Brute Force S.C=O(N);
    public static void rotate(int[] nums, int k) {
        int temp[] = new int[nums.length];
        int j = 0;
        k = k % nums.length;

        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j++] = nums[i];
        }

        for (int i = 0; i < nums.length - k; i++) {
            temp[j++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    // Approach 2 Using O(k) space
    public static void rotate2(int nums[], int k) {
        int n = nums.length;
        k %= n;
        int temp[] = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    // Approach 3 Using O(1) Space
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        // Reverse Full Array
        reverse(nums, 0, n - 1);

        // Reverse first K elements
        reverse(nums, 0, k - 1);

        // Reverse Remaining Elements
        reverse(nums, k, n - 1);
    }

    public static void reverse(int nums[], int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

    }
}
