import java.util.*;

//Approach Binary Search on Ans O(nlogn)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int left = 0;
        int right = 1000000001;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(houses, heaters, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int houses[], int heaters[], int radius) {
        int heaterIndex = 0;

        for (int house : houses) {
            while (heaterIndex < heaters.length && heaters[heaterIndex] + radius < house) {
                heaterIndex++;
            }

            if (heaterIndex == heaters.length) {
                return false;
            }

            if (heaters[heaterIndex] + radius < house) {
                return false;
            }

            if (heaters[heaterIndex] - radius > house) {
                return false;
            }
        }

        return true;

    }
}