import java.util.*;

public class Minimum_Dominos_Rotation_for_Equal_Row {

    // Applying Greedy Solution
    public static int minDominoRotations(int tops[], int bottoms[]) {
        int n = tops.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            int topCount = 0;
            int bottomCount = 0;
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                if (tops[j] != i && bottoms[j] != i) {
                    isValid = false;
                    break;
                }

                if (tops[j] != i) {
                    topCount++;
                }
                if (bottoms[j] != i) {
                    bottomCount++;
                }
            }

            if (isValid) {
                ans = Math.min(ans, Math.min(topCount, bottomCount));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String args[]) {
        int tops[] = { 2, 1, 2, 4, 2, 2 };
        int bottoms[] = { 5, 2, 6, 2, 3, 2 };

        System.out.println(minDominoRotations(tops, bottoms));
    }
}
