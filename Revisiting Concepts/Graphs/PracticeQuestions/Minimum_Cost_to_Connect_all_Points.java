import java.util.*;

public class Minimum_Cost_to_Connect_all_Points {

    // Prim's Algorithm -> MST
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int diff = Math.abs(x2 - x1) + Math.abs(y2 - y1);

                graph.get(i).add(new int[] { j, diff });
                graph.get(j).add(new int[] { i, diff });
            }
        }

        return PrimsAlgo(graph, n);
    }

    public static int PrimsAlgo(List<List<int[]>> graph, int n) {
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean visited[] = new boolean[n];
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            cost += weight;

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int newWeight = neighbour[1];

                if (!visited[newNode]) {
                    pq.offer(new int[] { newNode, newWeight });
                }
            }
        }

        return cost;
    }

    // Approach 2 Kruskal's Algo -> MST
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
                size[i] = i;
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

    public static int minCostConnectPoints2(int[][] points) {
        int n = points.length;
        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int diff = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                graph.add(new Edge(i, j, diff));
                graph.add(new Edge(j, i, diff));
            }
        }

        return KruskalsAlgo(graph, n);
    }

    public static int KruskalsAlgo(List<Edge> graph, int n) {
        Collections.sort(graph);

        DSU dsu = new DSU(n);
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

    public static void main(String args[]) {
        int points[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(minCostConnectPoints(points));
        System.out.println(minCostConnectPoints2(points));
    }
}
