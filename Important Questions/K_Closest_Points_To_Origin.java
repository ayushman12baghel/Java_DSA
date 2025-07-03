import java.util.*;

public class K_Closest_Points_To_Origin {

    // Approach Using PriorityQueue
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double d1 = (a[0] * a[0]) + (a[1] * a[1]);
            double d2 = (b[0] * b[0]) + (b[1] * b[1]);

            return Double.compare(d1, d2);
        });

        for (int point[] : points) {
            pq.offer(point);
        }

        int ans[][] = new int[k][2];
        int i = 0;

        while (k > 0) {
            int current[] = pq.poll();
            ans[i][0] = current[0];
            ans[i][1] = current[1];
            i++;
            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        int ans[][] = kClosest(points, k);

        for (int temp[] : ans) {
            System.out.print(temp[0] + " " + temp[1]);
            System.out.println();
        }
    }
}
