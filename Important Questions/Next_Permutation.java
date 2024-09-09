import java.util.*;

public class Next_Permutation {

    public static void nextPermutation(int nums[]) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0);
        } else {
            for (int i = nums.length - 1; i >= index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    reverse(nums, index + 1);
                    break;
                }
            }
        }
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int nums[], int index) {
        int i = index;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3 };

        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
