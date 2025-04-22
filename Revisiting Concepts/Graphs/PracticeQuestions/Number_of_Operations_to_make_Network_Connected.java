import java.util.*;

public class Number_of_Operations_to_make_Network_Connected {

    // Approach 1 DSU
    static class DSU {
        int parent[];
        int rank[];

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
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

            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
                rank[parentX]++;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
                rank[parentY]++;
            } else {
                parent[parentX] = parentY;
                rank[parentY]++;
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int components = n;
        DSU dsu = new DSU(n);

        for (int row[] : connections) {
            if (dsu.find(row[0]) == dsu.find(row[1])) {
                continue;
            } else {
                dsu.union(row[0], row[1]);
                components--;
            }
        }

        return components - 1;
    }

    // Approach 2 Using BFS
    public static int makeConnected2(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int row[] : connections) {
            graph.get(row[0]).add(row[1]);
            graph.get(row[1]).add(row[0]);
        }

        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int components = n;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                components--;
                continue;
            }

            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }

        return components - 1;
    }

    // Approach 3 Using DFS
    public static int makeConnected3(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int row[] : connections) {
            graph.get(row[0]).add(row[1]);
            graph.get(row[1]).add(row[0]);
        }

        boolean visited[] = new boolean[n];
        int components = n;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                components--;
                continue;
            }

            DFS(graph, visited, i);
        }

        return components - 1;
    }

    public static void DFS(List<List<Integer>> graph, boolean visited[], int i) {
        visited[i] = true;

        for (int neighbour : graph.get(i)) {
            if (!visited[neighbour]) {
                DFS(graph, visited, neighbour);
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int connections[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };

        System.out.println(makeConnected(n, connections));
        System.out.println(makeConnected2(n, connections));
        System.out.println(makeConnected3(n, connections));
    }
}
