import java.util.*;

public class Dijkstra_Algorithm {

    public static void createGraph(ArrayList<ArrayList<int[]>> graph, int V) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[] { 1, 2 });
        graph.get(0).add(new int[] { 2, 4 });

        graph.get(1).add(new int[] { 2, 1 });
        graph.get(1).add(new int[] { 3, 7 });
        graph.get(1).add(new int[] { 0, 2 });

        graph.get(2).add(new int[] { 4, 3 });
        graph.get(2).add(new int[] { 1, 1 });
        graph.get(2).add(new int[] { 0, 4 });

        graph.get(3).add(new int[] { 4, 2 });
        graph.get(3).add(new int[] { 5, 1 });
        graph.get(3).add(new int[] { 1, 7 });

        graph.get(4).add(new int[] { 2, 3 });
        graph.get(4).add(new int[] { 3, 2 });
        graph.get(4).add(new int[] { 5, 5 });

        graph.get(5).add(new int[] { 3, 1 });
        graph.get(5).add(new int[] { 4, 5 });
    }

    public static int[] dijkstra(ArrayList<ArrayList<int[]>> graph, int src) {
        int dist[] = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean visited[] = new boolean[graph.size()];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { src, 0 });
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int node = curr[0];
            int currDist = curr[1];

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            for (int neighbour[] : graph.get(node)) {
                int next = neighbour[0];
                int edgeWeight = neighbour[1];

                if (!visited[next] && currDist + edgeWeight < dist[next]) {
                    dist[next] = currDist + edgeWeight;
                    pq.offer(new int[] { next, dist[next] });
                }
            }
        }

        return dist;
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>(V);
        createGraph(graph, V);

        int ans[] = dijkstra(graph, 0);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
