import java.util.*;

public class Count_Unreachable_Pairs_of_Nodes_in_Undirected_Graph {

    // Approach 1 Using BFS
    public static long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        int remaining = n;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            int size = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                size++;

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }

            remaining = remaining - size;
            ans += (long) size * remaining;
        }

        return ans;
    }

    // Approach 2 Using DFS
    public static long countPairs2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        int remaining = n;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int size = DFS(graph, visited, i);
            remaining = remaining - size;
            ans += (long) size * remaining;
        }

        return ans;
    }

    public static int DFS(List<List<Integer>> graph, boolean visited[], int current) {
        visited[current] = true;
        int size = 1;

        for (int neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                size += DFS(graph, visited, neighbour);
            }
        }

        return size;
    }

    // Approach 3 Optimal Using DSU
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

    public static long countPairs3(int n, int[][] edges) {
        long ans = 0;
        int remaining = n;
        DSU dsu = new DSU(n);

        for (int edge[] : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int i = 0; i < n; i++) {
            if (dsu.parent[i] == i) {
                int size = dsu.size[i];
                remaining -= size;
                ans += (long) size * remaining;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int n = 7;
        int edges[][] = { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } };

        System.out.println(countPairs(n, edges));
        System.out.println(countPairs2(n, edges));
        System.out.println(countPairs3(n, edges));
    }
}
