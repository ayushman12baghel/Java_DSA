import java.util.Map;
import java.util.TreeMap;

public class PowerFul_Integer {

    // Brute Force Approach O(n*maxElement)
    public static int powerfulInteger(int[][] intervals, int k) {
        int maxInterval = intervals[0][1];
        for (int interval[] : intervals) {
            maxInterval = Math.max(maxInterval, interval[1]);
        }

        int count[] = new int[maxInterval + 1];

        for (int interval[] : intervals) {
            int start = interval[0];
            int end = interval[1];

            for (int i = start; i <= end; i++) {
                count[i]++;
            }
        }

        int ans = -1;

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k) {
                ans = i;
            }
        }

        return ans;
    }

    // More Optimised Using Difference Array O(maxElement || n) with space 10^9
    public static int powerfulInteger2(int[][] intervals, int k) {
        int maxInterval = intervals[0][1];
        for (int interval[] : intervals) {
            maxInterval = Math.max(maxInterval, interval[1]);
        }

        int diff[] = new int[maxInterval + 2];

        for (int interval[] : intervals) {
            int left = interval[0];
            int right = interval[1];

            diff[left]++;
            diff[right + 1]--;
        }

        int current = 0;
        int ans = -1;

        for (int i = 0; i < diff.length; i++) {
            current += diff[i];

            if (current >= k) {
                ans = i;
            }
        }

        return ans;
    }

    // Using TreeMap Defference Array Technique O(n logn)
    public static int powerfulInteger3(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int interval[] : intervals) {
            int start = interval[0];
            int end = interval[1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int ans = -1;
        int current = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (current >= k) {
                ans = key - 1;
            }

            current += value;
        }

        return ans;
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 4, 6 }, { 3, 4 } }, k = 2;

        System.out.println(powerfulInteger(intervals, k));
        System.out.println(powerfulInteger2(intervals, k));
    }
}
