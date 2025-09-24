import java.util.*;

class Solution {
    int counts[];

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        counts = new int[n];
        int indexes[] = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1, indexes);

        List<Integer> ans = new ArrayList<>();
        for (int count : counts) {
            ans.add(count);
        }

        return ans;
    }

    public void mergeSort(int nums[], int left, int right, int indexes[]) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, indexes);
        mergeSort(nums, mid + 1, right, indexes);
        merge(nums, left, mid, right, indexes);
    }

    public void merge(int nums[], int left, int mid, int right, int indexes[]) {
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k++] = indexes[j++];
                rightCount++;
            } else {
                counts[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            counts[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }

        while (j <= right) {
            temp[k++] = indexes[j++];
        }

        for (i = 0; i < temp.length; i++) {
            indexes[left + i] = temp[i];
        }
    }
}