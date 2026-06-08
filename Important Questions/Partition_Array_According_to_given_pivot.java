import java.util.*;

//Approach 1 Using Different Lists to Store the values O(n) time and O(n) space 
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int equal = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                smaller.add(nums[i]);
            } else if (nums[i] == pivot) {
                equal++;
            } else {
                greater.add(nums[i]);
            }
        }

        int ans[] = new int[nums.length];
        int i = 0;
        for (int num : smaller) {
            ans[i++] = num;
        }

        while (equal-- > 0) {
            ans[i++] = pivot;
        }

        for (int num : greater) {
            ans[i++] = num;
        }

        return ans;
    }
}

// Approach 2 O(n) time and O(1) space using two pointer algo
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;
        int ans[] = new int[n];

        for (int i = 0, j = n - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }

            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }
        }

        while (left <= right) {
            ans[left++] = pivot;
        }

        return ans;
    }
}