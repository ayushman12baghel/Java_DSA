import java.util.*;

public class Kosarajus_Algorithm_Strongly_Connected_Components {

    public static int kosaraju(List<List<Integer>> graph) {
        int n = graph.size();

        // Step 1 Stack me topological order me dalo
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsFill(graph, stack, visited, i);
            }
        }

        // Step 2 Reverse the Edges
        List<List<Integer>> graphReversed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphReversed.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbour : graph.get(i)) {
                graphReversed.get(neighbour).add(i);
            }
        }

        // Step 3 Stack ke order me dfs lagao
        visited = new boolean[n];
        int count = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                dfs(graphReversed, visited, current);
                count++;
            }
        }

        return count;
    }

    public static void dfsFill(List<List<Integer>> graph, Stack<Integer> stack, boolean visited[], int current) {
        visited[current] = true;

        for (int neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                dfsFill(graph, stack, visited, neighbour);
            }
        }

        stack.push(current);
    }

    public static void dfs(List<List<Integer>> graph, boolean visited[], int current) {
        visited[current] = true;

        for (int neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                dfs(graph, visited, neighbour);
            }
        }
    }

    public static void main(String[] args) {
        int V = 8;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(4);
        adj.get(6).add(7);

        System.out.println(kosaraju(adj));
    }
}
