import java.util.*;

public class Bellman_Ford_Algorithm {

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int ans[] = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (int edge[] : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (ans[u] != Integer.MAX_VALUE && ans[u] + w < ans[v]) {
                    ans[v] = ans[u] + w;
                }
            }
        }

        // Checking for negative cycle
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (ans[u] != Integer.MAX_VALUE && ans[u] + w < ans[v]) {
                return new int[] { -1 };
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int edges[][] = { { 0, 1, 4 }, { 1, 2, -6 }, { 2, 3, 5 }, { 3, 1, -2 } };
        int V = 4;
        int src = 0;

        int ans[] = bellmanFord(V, edges, src);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
