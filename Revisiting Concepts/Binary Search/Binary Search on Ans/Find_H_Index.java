import java.util.*;

public class Find_H_Index {

    // Binary Search on Ans
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(citations, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int target) {
        int count = 0;

        for (int num : nums) {
            if (num >= target) {
                count++;
            }

            if (count >= target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 0, 5, 3, 0 };

        System.out.println(hIndex(nums));
    }
}
