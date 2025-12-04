import java.util.*;

//O(n)
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int R = 0;
        int L = 0;
        int S = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if (c == 'S') {
                ans += (R);
                R = 0;
                S++;
            } else if (c == 'L') {
                if (R > 0) {
                    ans += 2;
                    R--;
                    S++;
                    while (R > 0) {
                        ans += R;
                        R = 0;
                    }
                } else if (S > 0) {
                    ans += L + 1;
                    L = 0;
                }
            } else {
                R++;
            }
        }

        return ans;
    }
}