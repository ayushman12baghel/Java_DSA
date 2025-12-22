import java.util.*;

//Approach Binary Search O(nlogm)

class Solution {
    public int rowWithMax1s(int nums[][]) {
        int maxCount = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentIndex = binarySearch(nums[i]);
            int count = nums[i].length - currentIndex;

            if (count > maxCount) {
                index = i;
                maxCount = count;
            }
        }

        return index;
    }

    public int binarySearch(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == 1) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] == 0) {
                left = mid + 1;
            }
        }

        return result;
    }
}