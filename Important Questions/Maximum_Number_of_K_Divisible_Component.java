import java.util.*;

//O(V+E)
class Solution {
    int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];

        solve(graph, 0, k, visited, values);

        return count;
    }

    public int solve(List<List<Integer>> graph, int index, int k, boolean visited[], int values[]) {
        visited[index] = true;
        int total = values[index];

        for (int neighbour : graph.get(index)) {
            if (!visited[neighbour]) {
                total += solve(graph, neighbour, k, visited, values);
            }
        }

        count += (total % k == 0 ? 1 : 0);

        return total % k;
    }
}