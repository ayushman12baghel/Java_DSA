import java.util.*;

//Approach log(y)
class Solution {
    public boolean isPower(int x, int y) {
        if (x == 1) {
            return y == 1;
        }

        while (y % x == 0) {
            y /= x;
        }

        return y == 1;
    }
}