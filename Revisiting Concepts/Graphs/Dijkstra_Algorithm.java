import java.util.*;

public class Dijkstra_Algorithm {

    // Approach 1 Using PriorityQueue
    public static int[] dijkstra(List<List<int[]>> graph, int src) {
        int ans[] = new int[graph.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });
        ans[src] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (weight > ans[node])
                continue;

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int newWeight = neighbour[1];

                if (weight + newWeight < ans[newNode]) {
                    ans[newNode] = weight + newWeight;
                    pq.offer(new int[] { newNode, ans[newNode] });
                }
            }
        }

        return ans;
    }

    // Using TreeSet
    public static int[] dijkstra2(List<List<int[]>> graph, int src) {
        int dist[] = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        TreeSet<int[]> set = new TreeSet<>((a, b) -> Integer.compare(a[1], b[1]));
        set.add(new int[] { src, 0 });

        while (!set.isEmpty()) {
            int curr[] = set.pollFirst();
            int node = curr[0];
            int currDist = curr[1];

            for (int neighbour[] : graph.get(node)) {
                int next = neighbour[0];
                int edgeWeight = neighbour[1];

                if (currDist + edgeWeight < dist[next]) {
                    set.remove(new int[] { next, dist[next] });
                    dist[next] = currDist + edgeWeight;
                    set.add(new int[] { next, dist[next] });
                }
            }
        }

        return dist;
    }

    public static void main(String args[]) {
        int edges[][] = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } };
        int src = 2;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        int ans[] = dijkstra(graph, src);
        int ans2[] = dijkstra2(graph, src);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " " + ans2[i] + " ");
        }
    }
}
