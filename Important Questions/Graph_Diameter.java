import java.util.*;

// Approach Using BFS
class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int findFarthesetPoint[] = bfs(graph, 0);

        int second[] = bfs(graph, findFarthesetPoint[0]);

        return second[1];
    }

    public int[] bfs(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.size()];
        queue.offer(start);
        visited[start] = true;
        int farthest = start;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                System.out.println(current);

                if (i == size - 1) {
                    farthest = current;
                }

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }

            distance++;
        }

        return new int[] { farthest, distance };
    }
}