import java.util.*;

// Approach 1 Brute Force O(n^2)
class Solution {
    static int inversionCount(int nums[]) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}

// Approach 2 Optimised Using MergeSort O(nlogn)
class Solution {
    static int inversionCount(int nums[]) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int nums[], int left, int right) {
        if (left >= right) {
            return 0;
        }

        int count = 0;
        int mid = left + (right - left) / 2;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countPairs(nums, left, mid, right);
        merge(nums, left, mid, right);

        return count;
    }

    static int countPairs(int nums[], int left, int mid, int right) {
        int count = 0;
        int high = mid + 1;

        while (left <= mid) {
            while (high <= right && nums[left] > nums[high]) {
                high++;
            }

            count += (high - (mid + 1));
            left++;
        }

        return count;
    }

    static void merge(int nums[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j];
                j++;
            } else {
                temp[k++] = nums[i];
                i++;
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = temp[k];
        }
    }
}