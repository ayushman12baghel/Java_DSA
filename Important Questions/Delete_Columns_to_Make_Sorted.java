import java.util.*;

//O(n*m)
class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int count = 0;

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows - 1; r++) {
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}