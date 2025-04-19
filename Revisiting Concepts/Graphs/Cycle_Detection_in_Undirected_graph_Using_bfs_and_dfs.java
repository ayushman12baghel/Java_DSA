import java.util.*;
import java.util.LinkedList;

public class Cycle_Detection_in_Undirected_graph_Using_bfs_and_dfs {

    // By DFS
    public static boolean isCycleDFS(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (dfsCyleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsCyleUtil(List<List<Integer>> list, boolean visited[], int curr, int par) {
        visited[curr] = true;

        for (int neighbour : list.get(curr)) {
            if (!visited[neighbour]) {
                if (dfsCyleUtil(list, visited, neighbour, curr)) {
                    return true;
                }
            } else if (neighbour != par) {
                return true;
            }
        }

        return false;
    }

    // By BFS
    public static boolean isCycleBFS(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (bfsCycleUtil(graph, visited, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean bfsCycleUtil(List<List<Integer>> graph, boolean visited[], int curr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { curr, -1 });
        visited[curr] = true;

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            int source = temp[0];
            int parent = temp[1];

            for (int neighbour : graph.get(source)) {
                if (!visited[neighbour]) {
                    queue.offer(new int[] { neighbour, source });
                    visited[neighbour] = true;
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int[][] graph = {
                /*
                 * A —— B —— D
                 * | | |
                 * C E —— F
                 * 
                 */
                { 0, 1, 1, 0, 0, 0 }, // A (0)
                { 1, 0, 0, 1, 1, 0 }, // B (1)
                { 1, 0, 0, 0, 0, 0 }, // C (2)
                { 0, 1, 0, 0, 0, 1 }, // D (3)
                { 0, 1, 0, 0, 0, 1 }, // E (4)
                { 0, 0, 0, 1, 1, 0 }
        };
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        System.out.println(isCycleDFS(list));
        System.out.println(isCycleBFS(list));
    }
}
