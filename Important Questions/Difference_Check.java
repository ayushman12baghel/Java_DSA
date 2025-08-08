import java.util.*;

public class Difference_Check {

    public static int minDifference(String[] arr) {
        int n = arr.length;
        int[] seconds = getSeconds(arr);

        Arrays.sort(seconds);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        int circularDiff = (24 * 3600 - seconds[n - 1]) + seconds[0];
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }

    private static int[] getSeconds(String[] arr) {
        int[] seconds = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String time = arr[i];
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            int s = Integer.parseInt(time.substring(6, 8));

            seconds[i] = h * 3600 + m * 60 + s;
        }

        return seconds;
    }

    public static void main(String[] args) {
        String arr[] = { "00:00:01", "23:59:59", "00:00:05" };

        System.out.println(minDifference(arr));
    }
}
