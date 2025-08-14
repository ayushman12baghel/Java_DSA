import java.util.*;

public class Count_Reverse_Pairs {

    // Using MergeSort
    public static int countRevPairs(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    public static int mergeSortAndCount(int nums[], int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSortAndCount(nums, left, mid);
        count += mergeSortAndCount(nums, mid + 1, right);

        count += countCrossPairs(nums, left, mid, right);
        merge(nums, left, mid, right);

        return count;
    }

    public static int countCrossPairs(int nums[], int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += (j - mid - 1);
        }

        return count;
    }

    public static void merge(int nums[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 4, 5, 1, 20 };

        System.out.println(countRevPairs(nums));
    }
}
