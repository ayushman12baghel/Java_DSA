import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static int minArrows(int points[][]) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        int prev[] = points[0];

        for (int i = 1; i < points.length; i++) {
            int prevStart = prev[0];
            int prevEnd = prev[1];
            int currStart = points[i][0];
            int currEnd = points[i][1];

            if (currStart > prevEnd) {
                count++;
                prev = points[i];
            } else {
                prev[0] = Math.max(prevStart, currStart);
                prev[1] = Math.min(prevEnd, currEnd);
            }
        }

        return count;
    }

    public static int minArrows2(int points[][]) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int points[][] = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

        System.out.println(minArrows(points));
        System.out.println(minArrows2(points));
    }
}
