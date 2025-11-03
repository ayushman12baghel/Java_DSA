import java.util.*;

// Approach Using Kadane's Algo for Topological Sort
// O(V+E)
class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[V];

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            for (int neighbour : graph.get(current)) {
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}