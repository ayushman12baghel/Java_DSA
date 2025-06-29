import java.util.*;

public class Merge_Intervals {

    // brute force
    public static int[][] merge(int intervals[][]) {
        int n = intervals.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int interval[] : intervals) {
            List<Integer> temp = new ArrayList<>();
            temp.add(interval[0]);
            temp.add(interval[1]);
            list.add(temp);
        }

        Collections.sort(list, (a, b) -> a.get(0) - b.get(0));
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);

            if (!ans.isEmpty()) {
                if (start <= ans.get(ans.size() - 1).get(1)) {
                    continue;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (list.get(j).get(0) <= end) {
                    if (end <= list.get(j).get(1)) {
                        end = list.get(j).get(1);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            res.add(start);
            res.add(end);
            ans.add(new ArrayList<>(res));
        }

        int x[][] = new int[ans.size()][2];
        int k = 0;
        for (List<Integer> l : ans) {
            x[k][0] = l.get(0);
            x[k][1] = l.get(1);
            k++;
        }

        return x;
    }

    // optimised sol'n
    public static int[][] merge2(int intervals[][]) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int newInterval[] = intervals[0];
        result.add(newInterval);

        for (int interval[] : intervals) {
            // overlapping intervals
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // disjoint intervals
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // Optimised and Easy to understand
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int newInterval[] = intervals[0];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                result.add(newInterval);
                newInterval = intervals[i];
            }
        }
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String args[]) {
        int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int ans[][] = merge(intervals);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        int ans2[][] = merge2(intervals);

        for (int i = 0; i < ans2.length; i++) {
            for (int j = 0; j < ans2[0].length; j++) {
                System.out.print(ans2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
