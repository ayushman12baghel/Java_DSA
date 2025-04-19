import java.util.*;

public class Cycle_Detection_in_Directed_Graph_Using_Dfs_and_Bfs {

    // Using DFS
    public static boolean isCycleDFS(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];
        boolean inRecursion[] = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (dfsCycleUtil(graph, visited, inRecursion, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsCycleUtil(List<List<Integer>> graph, boolean visited[], boolean inRecursion[], int curr) {
        visited[curr] = true;
        inRecursion[curr] = true;

        for (int neighbour : graph.get(curr)) {
            if (!visited[neighbour]) {
                if (dfsCycleUtil(graph, visited, inRecursion, neighbour)) {
                    return true;
                }
            } else if (inRecursion[neighbour]) {
                return true;
            }
        }

        inRecursion[curr] = false;

        return false;
    }

    public static boolean isCycleBFS(List<List<Integer>> graph) {
        int indeg[] = new int[graph.size()];
        for (List<Integer> list : graph) {
            for (int num : list) {
                indeg[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int neighbour : graph.get(curr)) {
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return count != graph.size();
    }

    public static void main(String args[]) {
        /*
         * A <- B <- C
         * ↓ ------↑
         * D → E → F
         * 
         */
        int[][] graph = {
                // A B C D E F
                { 0, 0, 0, 1, 0, 0 }, // A
                { 1, 0, 0, 0, 0, 0 }, // B
                { 0, 1, 0, 0, 0, 0 }, // C
                { 0, 0, 0, 0, 1, 0 }, // D
                { 0, 0, 0, 0, 0, 1 }, // E
                { 0, 0, 1, 0, 0, 0 } // F
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
