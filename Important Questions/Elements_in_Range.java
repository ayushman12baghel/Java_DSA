import java.util.*;

//Approach Binary Search O(nlogn + nlog(q))
class Solution {
    public ArrayList<Integer> cntInRange(int[] nums, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int query[] : queries) {
            int left = query[0];
            int right = query[1];

            int leftIndex = binarySearch2(nums, left);
            int rightIndex = binarySearch(nums, right);

            if (leftIndex != -1 && rightIndex != -1 && leftIndex <= rightIndex) {
                ans.add(rightIndex - leftIndex + 1);
            } else {
                ans.add(0);
            }
        }

        return ans;
    }

    public int binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int binarySearch2(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
