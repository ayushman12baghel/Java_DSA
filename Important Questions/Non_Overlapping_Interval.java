import java.util.*;

public class Non_Overlapping_Interval {

    public static int minOverlapping(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev[] = intervals[0];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                count++;
            } else {
                prev = intervals[i];
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };

        System.out.println(minOverlapping(intervals));
    }
}
