import java.util.*;

//Approach Binary Search O(nlogn)
class Solution {
    public ArrayList<Integer> countXInRange(int[] nums, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int query[] : queries) {
            int first = binarySearch(nums, query[0], query[1], query[2]);
            if (first == -1) {
                ans.add(0);
                continue;
            }
            int last = binarySearch2(nums, query[0], query[1], query[2]);

            ans.add(last - first + 1);
        }

        return ans;
    }

    public int binarySearch2(int nums[], int left, int right, int target) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int binarySearch(int nums[], int left, int right, int target) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}