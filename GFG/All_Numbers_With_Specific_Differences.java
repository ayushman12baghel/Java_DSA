import java.util.*;

//Approach Using BinarySearch O(logn*logn)
class Solution {
    public int getCount(int n, int d) {
        int left = 0;
        int right = n;
        int result = n + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isGreater(mid, d)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n + 1 - result;
    }

    public boolean isGreater(int n, int d) {
        int sum = 0;
        int value = n;

        while (value > 0) {
            int ld = value % 10;
            sum += ld;
            value /= 10;
        }

        return n - sum >= d;
    }
};