import java.util.*;
import java.io.*;

class Approach1 { // Prim's Algorithm

    static class Pair {
        int node;
        long weight;

        public Pair(int n, long w) {
            this.node = n;
            this.weight = w;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine[] = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String parts[] = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            long w = Long.parseLong(parts[2]);

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        boolean visited[] = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        pq.offer(new Pair(1, 0));
        long cost = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            long weight = current.weight;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            cost += weight;
            count++;

            for (Pair neighbour : graph.get(node)) {
                if (!visited[neighbour.node]) {
                    pq.offer(new Pair(neighbour.node, neighbour.weight));
                }
            }
        }

        if (count == n) {
            System.out.println(cost);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}

// Approach 2 Kruskal's Algorithm

public class Road_Reparation {

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.w, e.w);
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
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine[] = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String parts[] = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            long w = Long.parseLong(parts[2]);

            graph.add(new Edge(u, v, w));
        }

        Collections.sort(graph);

        DSU dsu = new DSU(n + 1);
        int count = 0;
        long cost = 0;

        for (Edge edge : graph) {
            int u = edge.u;
            int v = edge.v;
            long w = edge.w;

            if (dsu.find(u) != dsu.find(v)) {
                cost += w;
                dsu.union(u, v);
                count++;
            }
        }

        if (count == n - 1) {
            System.out.println(cost);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}