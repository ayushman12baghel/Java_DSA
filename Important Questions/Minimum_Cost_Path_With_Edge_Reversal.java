import java.util.*;

//Approach Using Dijkstra Algo O(nlogn)
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, 2 * w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[] { 0, 0 });
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int v = neighbour[0];
                int weight = neighbour[1];

                if (weight + dist[node] < dist[v]) {
                    dist[v] = weight + dist[node];
                    pq.offer(new int[] { v, dist[v] });
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}