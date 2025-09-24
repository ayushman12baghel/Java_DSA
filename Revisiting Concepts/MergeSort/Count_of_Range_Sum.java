import java.util.*;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }

        return mergeSortAndCount(prefix, 0, prefix.length - 1, lower, upper);
    }

    public int mergeSortAndCount(long prefix[], int left, int right, int lower, int upper) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;
        count += mergeSortAndCount(prefix, left, mid, lower, upper);
        count += mergeSortAndCount(prefix, mid + 1, right, lower, upper);
        count += countCrissCross(prefix, left, mid, right, lower, upper);
        merge(prefix, left, mid, right, lower, upper);

        return count;
    }

    public int countCrissCross(long prefix[], int left, int mid, int right, int lower, int upper) {
        int count = 0;
        int l = mid + 1;
        int r = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (l <= right && prefix[l] - prefix[i] < lower) {
                l++;
            }

            while (r <= right && prefix[r] - prefix[i] <= upper) {
                r++;
            }

            count += (r - l);
        }

        return count;
    }

    public void merge(long nums[], int left, int mid, int right, int lower, int upper) {
        long temp[] = new long[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] >= nums[j]) {
                temp[k++] = nums[j];
                j++;
            } else {
                temp[k++] = nums[i];
                i++;
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i];
            i++;
        }

        while (j <= right) {
            temp[k++] = nums[j];
            j++;
        }

        for (i = 0; i < temp.length; i++) {
            nums[i + left] = temp[i];
        }
    }
}