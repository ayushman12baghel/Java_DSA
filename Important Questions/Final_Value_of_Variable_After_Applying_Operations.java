import java.util.*;

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;

        for (String temp : operations) {
            if (temp.equals("--X") || temp.equals("X--")) {
                ans -= 1;
            } else {
                ans += 1;
            }
        }

        return ans;
    }
}