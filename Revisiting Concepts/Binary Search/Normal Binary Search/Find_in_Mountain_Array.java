/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        int peak = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                peak = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int searchLeft = binarySearch1(mountainArr, n, target, peak - 1);
        if (searchLeft != -1) {
            return searchLeft;
        }

        return binarySearch2(mountainArr, n, target, peak);
    }

    public int binarySearch1(MountainArray mountainArr, int n, int target, int right) {
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mountainArr.get(mid);

            if (target == temp) {
                return mid;
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearch2(MountainArray mountainArr, int n, int target, int left) {
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mountainArr.get(mid);

            if (target == temp) {
                return mid;
            } else if (target > temp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}