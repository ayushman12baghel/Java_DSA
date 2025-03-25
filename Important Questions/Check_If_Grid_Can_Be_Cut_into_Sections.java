import java.util.*;

public class Check_If_Grid_Can_Be_Cut_into_Sections {

    public static boolean checkValidCuts(int rectangles[][]) {
        List<int[]> horizontal = new ArrayList<>();
        List<int[]> vertical = new ArrayList<>();

        for (int rectangle[] : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];

            horizontal.add(new int[] { x1, x2 });
            vertical.add(new int[] { y1, y2 });
        }

        int horizontalArray[][] = horizontal.toArray(new int[horizontal.size()][]);
        int verticalArray[][] = vertical.toArray(new int[vertical.size()][]);

        int mergeX[][] = merge(horizontalArray);

        if (mergeX.length >= 3) {
            return true;
        }

        int mergeY[][] = merge(verticalArray);

        if (mergeY.length >= 3) {
            return true;
        }

        return false;
    }

    public static int[][] merge(int intervals[][]) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int newInterval[] = intervals[0];
        list.add(newInterval);

        for (int interval[] : intervals) {
            if (interval[0] < newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                list.add(newInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String args[]) {
        int rectangles[][] = { { 1, 0, 5, 2 }, { 0, 2, 2, 4 }, { 3, 2, 5, 3 }, { 0, 4, 4, 5 } };

        System.out.println(checkValidCuts(rectangles));
    }
}
