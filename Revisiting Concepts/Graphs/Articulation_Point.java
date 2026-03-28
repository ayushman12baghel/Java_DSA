import java.util.*;

//Approach Tarjan's Algorithm O(V+E)
class Solution {
    static int timer = 0;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        timer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int disc[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        boolean mark[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, disc, low, visited, mark);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (mark[i]) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }

    public static void dfs(List<List<Integer>> graph, int u, int parent, int disc[], int low[], boolean visited[],
            boolean mark[]) {
        visited[u] = true;
        disc[u] = low[u] = timer++;
        int children = 0;

        for (int v : graph.get(u)) {
            if (parent == v) {
                continue;
            }

            if (!visited[v]) {
                children++;

                dfs(graph, v, u, disc, low, visited, mark);

                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= disc[u]) {
                    mark[u] = true;
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1) {
            mark[u] = true;
        }
    }
}