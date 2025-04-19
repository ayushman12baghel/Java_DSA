import java.util.*;

public class Topological_Sort {

    // Using DFS
    public static List<Integer> topologicalSortDFS(int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean visited[] = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                DFS(graph, visited, stack, i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void DFS(List<List<Integer>> graph, boolean visited[], Stack<Integer> stack, int curr) {
        visited[curr] = true;

        for (int neighbour : graph.get(curr)) {
            if (!visited[neighbour]) {
                DFS(graph, visited, stack, neighbour);
            }
        }

        stack.push(curr);
    }

    // Using Kahn's Algorithm
    public static List<Integer> topologicalSortBFS(int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        int indeg[] = new int[edges.length];
        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int neighbour : graph.get(curr)) {
                indeg[neighbour]--;

                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        /*
         * 4 → 1 → 3
         * ↓ --↑
         * 0 --↑
         * ↑ --↑
         * 5 → 2
         */

        int[][] edges = {
                { 1, 3 },
                { 2, 3 },
                { 4, 1 },
                { 4, 0 },
                { 5, 0 },
                { 5, 2 }
        };

        System.out.println(topologicalSortDFS(edges));

        System.out.println(topologicalSortBFS(edges));
    }
}
