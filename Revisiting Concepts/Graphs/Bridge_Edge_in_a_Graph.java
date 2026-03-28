import java.util.*;

//Approach 1 DSU O(V+E) but will take more if we have to find Articulation point about O(V*E)
class Solution {
    class DSU {
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
            } else {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            }
        }
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        DSU dsu1 = new DSU(V);
        DSU dsu2 = new DSU(V);

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            dsu1.union(u, v);

            if ((u == c && v == d) || (u == d && v == c)) {
                continue;
            }

            dsu2.union(u, v);
        }

        return getComponents(dsu1, V) != getComponents(dsu2, V);
    }

    public int getComponents(DSU dsu, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                count++;
            }
        }

        return count;
    }
}

// Approach 2 is Tarjan's Algo O(V + E)
class Solution {
    int timer = 1;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        timer = 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int disc[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, -1, disc, low, visited, c, d)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(List<List<Integer>> graph, int u, int parent, int disc[], int low[], boolean visited[], int c,
            int d) {
        visited[u] = true;

        disc[u] = timer;
        low[u] = timer;
        timer++;

        for (int v : graph.get(u)) {
            if (v == parent) {
                continue;
            }

            if (!visited[v]) {
                if (dfs(graph, v, u, disc, low, visited, c, d)) {
                    return true;
                }

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    if ((u == c && v == d) || (u == d && v == c)) {
                        return true;
                    }
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        return false;
    }
}

// Approach 3 Using BFS O(V + E)
class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            if ((u == c && v == d) || (u == d && v == c)) {
                continue;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];

        queue.offer(c);
        visited[c] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == d) {
                return false;
            }

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return true;
    }
}