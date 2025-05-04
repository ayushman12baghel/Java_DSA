import java.util.ArrayList;
import java.util.List;

public class Euler_Path_and_Circuit {
    public static int isEulerCircuit(int V, List<List<Integer>> graph) {
        if (!isConnected(graph, V)) {
            return 0;
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        if (evenCount == V) {
            return 2;
        } else if (oddCount == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean isConnected(List<List<Integer>> graph, int V) {
        int nonZero = -1;

        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() != 0) {
                nonZero = i;
                break;
            }
        }

        boolean visited[] = new boolean[V];
        dfs(graph, visited, nonZero);

        for (int i = 0; i < V; i++) {
            if (!visited[i] && graph.get(i).size() > 0) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(List<List<Integer>> graph, boolean visited[], int current) {
        if (current != -1) {
            visited[current] = true;

            for (int neigh : graph.get(current)) {
                if (!visited[neigh]) {
                    dfs(graph, visited, neigh);
                }
            }
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = 3;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(1);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(0);

        System.out.println(isEulerCircuit(n, graph));
    }
}
