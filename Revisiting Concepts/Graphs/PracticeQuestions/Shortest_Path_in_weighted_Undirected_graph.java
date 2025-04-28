import java.util.*;

public class Shortest_Path_in_weighted_Undirected_graph {

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Code Here.
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { 0, 0 });
        int dist[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

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
                    parent[newNode] = node;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int x = n - 1;

        if (dist[x] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        ans.add(dist[x]);
        List<Integer> path = new ArrayList<>();

        while (x != -1) {
            path.add(x + 1);
            x = parent[x];
        }

        Collections.reverse(path);

        for (int node : path) {
            ans.add(node);
        }

        return ans;
    }

    public static void main(String args[]) {
        int n = 5;
        int m = 6;
        int edges[][] = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };

        System.out.println(shortestPath(n, m, edges));
    }
}
