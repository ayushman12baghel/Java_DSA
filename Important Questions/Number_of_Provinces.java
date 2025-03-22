import java.util.*;
import java.util.LinkedList;

public class Number_of_Provinces {

    // Approach 1 Using BFS
    public static int findCircleNum(int isConnected[][]) {
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, visited, i);
                result++;
            }
        }

        return result;
    }

    public static void bfs(List<List<Integer>> graph, boolean visited[], int i) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.offer(i);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbour : graph.get(curr)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    // Approach 2 Using DFS
    public static void dfs(List<List<Integer>> graph, boolean visited[], int i) {
        visited[i] = true;

        for (int neighbour : graph.get(i)) {
            if (!visited[neighbour]) {
                dfs(graph, visited, neighbour);
            }
        }
    }

    // Approach 3 Using DSU -> Disjoint Set Union Algorithm
    static class DSU {
        int n;
        int parent[];
        int size[];

        public DSU(int n) {
            this.n = n;
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

    public static int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    dsu.union(i, j);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                result++;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int isConnected[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNum2(isConnected));
    }
}