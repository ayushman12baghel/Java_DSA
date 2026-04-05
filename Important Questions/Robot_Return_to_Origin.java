import java.util.*;

// O(n)
class Solution {
    public boolean judgeCircle(String moves) {
        int count1 = 0;
        int count2 = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                count1++;
            } else if (c == 'D') {
                count1--;
            } else if (c == 'L') {
                count2++;
            } else {
                count2--;
            }
        }

        return count1 == 0 && count2 == 0;
    }
}