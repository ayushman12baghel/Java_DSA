import java.util.*;

public class DFS_Traversal {

    public static List<Character> dfs(int graph[][]) {
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
        List<Character> result = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];
        dfsUtil(list, visited, result, 0);

        return result;
    }

    public static void dfsUtil(List<List<Integer>> graph, boolean visited[], List<Character> result, int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        result.add((char) (i + 'A'));

        for (int neighbour : graph.get(i)) {
            if (!visited[neighbour]) {
                dfsUtil(graph, visited, result, neighbour);
            }
        }
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
        int n = 4;

        List<Character> result = dfs(graph);
        System.out.println(result);
    }
}
