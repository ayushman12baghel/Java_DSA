import java.util.*;

public class Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_I {

    // Approach Using BFS
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> graph1 = buildGraph(edges1, n);
        List<List<Integer>> graph2 = buildGraph(edges2, m);

        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = bfs(graph1, i, k);
        }

        int maxAdd = 0;

        for (int i = 0; i < m; i++) {
            maxAdd = Math.max(maxAdd, bfs(graph2, i, k - 1));
        }

        if (k > 0) {
            for (int i = 0; i < ans.length; i++) {
                ans[i] += maxAdd;
            }
        }

        return ans;
    }

    public static List<List<Integer>> buildGraph(int edges[][], int n) {
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

        return graph;
    }

    public static int bfs(List<List<Integer>> graph, int x, int k) {
        if (k < 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.size()];
        queue.offer(x);
        visited[x] = true;
        int count = 1;

        while (!queue.isEmpty() && k-- > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int edges1[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        int k = 2;

        int ans[] = maxTargetNodes(edges1, edges2, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
