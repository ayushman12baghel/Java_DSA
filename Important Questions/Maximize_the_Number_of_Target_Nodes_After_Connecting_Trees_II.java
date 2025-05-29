import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_II {

    // Approach 1 T.L.E O(n^2+m^2)
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> graph1 = buildGraph(edges1, n);
        List<List<Integer>> graph2 = buildGraph(edges2, m);

        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = bfs(graph1, i, n, true);
        }

        int maxAdd = 0;

        for (int i = 0; i < m; i++) {
            maxAdd = Math.max(maxAdd, bfs(graph2, i, m, false));
        }

        for (int i = 0; i < n; i++) {
            ans[i] += maxAdd;
        }

        return ans;
    }

    public static List<List<Integer>> buildGraph(int edges[][], int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    public static int bfs(List<List<Integer>> graph, int node, int n, boolean isEven) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.offer(node);
        visited[node] = true;

        int count = (isEven ? 1 : 0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;

                        if (!isEven) {
                            count++;
                        }
                    }
                }
            }

            isEven = !isEven;
        }

        return count;
    }

    public static void main(String args[]) {
        int edges1[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };

        int ans[] = maxTargetNodes(edges1, edges2);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
