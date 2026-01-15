import java.util.*;

// O(vlogv +hlogh)
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = 1;
        int maxV = 1;
        int consecutive = 1;

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                consecutive++;
            } else {
                consecutive = 1;
            }

            maxH = Math.max(maxH, consecutive);
        }

        consecutive = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                consecutive++;
            } else {
                consecutive = 1;
            }

            maxV = Math.max(maxV, consecutive);
        }

        int side = Math.min(maxH, maxV) + 1;

        return side * side;
    }
}