import java.util.*;

public class Insert_Interval {

    public static int[][] insert(int intervals[][], int newInterval[]) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Case 1 Skipping non-Overlapping Intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // Case 2 Non-Overlapping Intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        // Add Remaining Intervals
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String args[]) {
        int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int newInterval[] = { 4, 8 };

        int ans[][] = insert(intervals, newInterval);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
