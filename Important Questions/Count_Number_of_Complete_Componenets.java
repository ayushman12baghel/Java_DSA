import java.util.*;
import java.util.LinkedList;

public class Count_Number_of_Complete_Componenets {

    // Approach 1 Using DFS counting the number of Componenets for Complete Graph as
    // Total number of edges=v*(v-1)/2
    public static int countCompleteComponents(int n, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean visited[] = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int info[] = new int[2];
                dfs(graph, visited, info, i);

                if ((info[0] * (info[0] - 1)) == info[1]) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void dfs(List<List<Integer>> graph, boolean visited[], int info[], int i) {
        visited[i] = true;
        info[0] += 1;
        info[1] += graph.get(i).size();

        for (int neighbour : graph.get(i)) {
            if (!visited[neighbour]) {
                dfs(graph, visited, info, neighbour);
            }
        }
    }

    // Approach 2 Using BFS
    public static int countCompleteComponents2(int n, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean visited[] = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int info[] = new int[2];
                bfs(graph, visited, info, i);

                if ((info[0] * (info[0] - 1)) == info[1]) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void bfs(List<List<Integer>> graph, boolean visited[], int info[], int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            info[0] += 1;
            info[1] += graph.get(curr).size();

            for (int neighbour : graph.get(curr)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    // Approach 3 Using DSU by SIze
    static class DSU {
        int n;
        int parent[];
        int size[];

        public DSU(int n) {
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                size[i] = 1;
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

    public static int countCompleteComponents3(int n, int edges[][]) {
        Map<Integer, Integer> map = new HashMap<>();
        DSU dsu = new DSU(n);

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            dsu.union(u, v);
        }

        // Count edges for each root
        for (int edge[] : edges) {
            int root = dsu.find(edge[0]);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                int v = dsu.size[i];
                int e = map.getOrDefault(i, 0);

                if ((v * (v - 1) / 2) == e) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int n = 6;
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countCompleteComponents(n, edges));
        System.out.println(countCompleteComponents2(n, edges));
        System.out.println(countCompleteComponents3(n, edges));
    }
}
