import java.util.*;

public class Kruskals_Algorithm_MST {
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.w - e2.w;
        }
    }

    static class DSU {
        int parent[];
        int size[];

        public DSU(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            if (size[parentX] > size[parentY]) {
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            } else if (size[parentX] < size[parentY]) {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            } else {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            }
        }
    }

    public static int minimumSpanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> graph = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int neighbour[] : adj.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];
                graph.add(new Edge(u, v, w));
            }
        }

        Collections.sort(graph);

        DSU dsu = new DSU(V);
        int cost = 0;

        for (Edge edge : graph) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;

            if (dsu.find(u) != dsu.find(v)) {
                cost += w;
                dsu.union(u, v);
            }
        }

        return cost;
    }
}
