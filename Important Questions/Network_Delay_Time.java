import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Network_Delay_Time {

    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int row[] : times) {
            int u = row[0];
            int v = row[1];
            int w = row[2];

            graph.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int minTime[] = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        pq.offer(new int[] { k, 0 });
        minTime[k] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (weight > minTime[node]) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int w = neighbour[1];

                if (w + weight < minTime[newNode]) {
                    minTime[newNode] = w + weight;
                    pq.offer(new int[] { newNode, w + weight });
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, minTime[i]);
        }

        return result;
    }

    public static void main(String args[]) {
        int times[][] = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
