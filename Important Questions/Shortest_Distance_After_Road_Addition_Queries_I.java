import java.util.*;
import java.util.LinkedList;

public class Shortest_Distance_After_Road_Addition_Queries_I {

    public static int bfs(List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n - 1) {
                    return level;
                }

                for (int neighbour : graph.get(curr)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static int[] shortestDistanceAfterQueries(int queries[][], int n) {
        List<List<Integer>> graph = new ArrayList<>();
        int ans[] = new int[queries.length];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int i = 0;
        for (int query[] : queries) {
            int u = query[0];
            int v = query[1];
            graph.get(u).add(v);
            ans[i++] = bfs(graph, n);
        }

        return ans;
    }

    public static void main(String args[]) {
        int n = 5;
        int queries[][] = { { 2, 4 }, { 0, 2 }, { 0, 4 } };

        int ans[] = shortestDistanceAfterQueries(queries, n);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
