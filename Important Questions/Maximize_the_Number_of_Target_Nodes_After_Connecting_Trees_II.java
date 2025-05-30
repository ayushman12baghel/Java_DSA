import java.util.ArrayList;
import java.util.Arrays;
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

    // Approach 2 Using Graph Coloring O(n+m)
    public static int[] maxTargetNodes2(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> graph1 = buildGraph(edges1, n);
        List<List<Integer>> graph2 = buildGraph(edges2, m);

        int color1[] = new int[n];
        Arrays.fill(color1, -1);
        bfs(graph1, color1, 0);

        int evenCount1 = 0;
        int oddCount1 = 0;

        for (int num : color1) {
            if (num == 0) {
                evenCount1++;
            } else {
                oddCount1++;
            }
        }

        int color2[] = new int[m];
        Arrays.fill(color2, -1);

        bfs(graph2, color2, 0);

        int evenCount2 = 0;
        int oddCount2 = 0;

        for (int num : color2) {
            if (num == 0) {
                evenCount2++;
            } else {
                oddCount2++;
            }
        }

        int maxCount = Math.max(evenCount2, oddCount2);

        int result[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (color1[i] == 0) {
                result[i] = evenCount1 + maxCount;
            } else {
                result[i] = oddCount1 + maxCount;
            }
        }

        return result;
    }

    public static void bfs(List<List<Integer>> graph, int color[], int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    if (color[neighbour] == -1) {
                        queue.offer(neighbour);
                        color[neighbour] = 1 - color[current];
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int edges1[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };

        int ans[] = maxTargetNodes2(edges1, edges2);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
