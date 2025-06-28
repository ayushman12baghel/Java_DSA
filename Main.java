import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            intervals[i][0] = Integer.parseInt(parts[0]);
            intervals[i][1] = Integer.parseInt(parts[1]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = 0;

        for (int[] movie : intervals) {
            if (movie[0] >= lastEnd) {
                count++;
                lastEnd = movie[1];
            }
        }

        System.out.println(count);
    }
}
