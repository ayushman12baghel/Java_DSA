import java.util.*;

public class Redundant_Connection {

    // BFS O(N2)
    public static int[] redundantConnection(int edges[][]) {
        List<List<Integer>> list = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            if (bfs(list, u, v)) {
                return edge;
            }

            list.get(u).add(v);
            list.get(v).add(u);
        }

        return new int[0];
    }

    public static boolean bfs(List<List<Integer>> list, int u, int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[list.size()];
        queue.offer(u);
        visited[u] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : list.get(current)) {
                if (neighbour == v) {
                    return true;
                }

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return false;
    }

    // Topological Sort BFS O(N)
    public static int[] findRedundantConnection(int edges[][]) {
        int n = edges.length;
        List<List<Integer>> list = new ArrayList<>();
        int indeg[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
            indeg[v]++;
            indeg[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            if (indeg[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : list.get(current)) {
                indeg[neighbour]--;
                indeg[current]--;
                if (indeg[neighbour] == 1) {
                    queue.offer(neighbour);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int edge[] = edges[i];

            if (indeg[edge[0]] > 0 && indeg[edge[1]] > 0) {
                return edge;
            }
        }

        return new int[0];
    }

    public static void main(String args[]) {
        int edges[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };

        int ans[] = redundantConnection(edges);
        for (int i = 0; i < 2; i++) {
            System.out.print(ans[i] + " ");

        }
        System.out.println();
        int ans2[] = findRedundantConnection(edges);
        for (int i = 0; i < 2; i++) {
            System.out.print(ans2[i] + " ");

        }
    }
}
