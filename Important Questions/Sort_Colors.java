import java.util.*;

public class Sort_Colors {

    // Approach 1 Merge Sort O(n*logn)
    public static void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int nums[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(nums, si, mid);
        mergeSort(nums, mid + 1, ei);

        merge(nums, si, mid, ei);
    }

    public static void merge(int nums[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }

    // Approach 2 USing Count
    public static void sortColors2(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero != 0) {
                nums[i] = 0;
                zero--;
            } else if (one != 0) {
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
                two--;
            }
        }
    }

    // Approach 3 Dutch National Flag Alforithm
    public static void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}
