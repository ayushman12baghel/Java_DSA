import java.util.*;

//Approach Using Binary Search O(logn)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = letters[0];

        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                result = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}