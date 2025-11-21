import java.util.*;

// Using Dijkstra Algo Time -> O((V+E)log V)
class Solution {
    public int shortestPath(int V, int a, int b, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int straight = edge[2];
            int curved = edge[3];

            graph.get(u).add(new int[] { v, straight, curved });
            graph.get(v).add(new int[] { u, straight, curved });
        }

        int dist[][] = new int[V][2];
        for (int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] { a, 0, 0 });
        dist[a][0] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];
            int used = current[2];

            if (node == b) {
                return weight;
            }

            if (weight > dist[node][used]) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int weightS = neighbour[1];
                int weightC = neighbour[2];

                if (weight + weightS < dist[newNode][used]) {
                    dist[newNode][used] = weight + weightS;
                    pq.offer(new int[] { newNode, dist[newNode][used], used });
                }

                if (used == 0 && weight + weightC < dist[newNode][1]) {
                    dist[newNode][1] = weight + weightC;
                    pq.offer(new int[] { newNode, dist[newNode][1], 1 });
                }
            }
        }

        return -1;
    }
}