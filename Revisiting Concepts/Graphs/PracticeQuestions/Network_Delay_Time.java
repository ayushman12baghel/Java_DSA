import java.util.*;

public class Network_Delay_Time {

    public static int networkDelayTime(int[][] edges, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[] { k, 0 });
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (weight > dist[node]) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int newWeight = neighbour[1];

                if (weight + newWeight < dist[newNode]) {
                    dist[newNode] = weight + newWeight;
                    pq.offer(new int[] { newNode, dist[newNode] });
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(dist[i], ans);
        }

        return ans;
    }

    public static void main(String args[]) {
        int times[][] = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
