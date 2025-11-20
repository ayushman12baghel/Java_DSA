import java.util.*;

//Approach Using Sorting O(nlog(n))
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> (a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]));

        int first = -1;
        int second = -1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (left <= first) {
                continue;
            }

            if (left > second) {
                second = right;
                first = right - 1;
                ans += 2;
            } else {// left<=second
                first = second;
                second = right;
                ans += 1;
            }
        }

        return ans;
    }
}