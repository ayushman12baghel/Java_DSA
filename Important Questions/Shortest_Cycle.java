import java.util.*;

//Approach Using BFS O(V * (V + E))
class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < V; start++) {
            Queue<Integer> queue = new LinkedList<>();

            int dist[] = new int[V];
            int parent[] = new int[V];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            queue.offer(start);
            dist[start] = 0;

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : graph.get(u)) {
                    if (dist[v] == -1) {
                        parent[v] = u;
                        dist[v] = dist[u] + 1;
                        queue.offer(v);
                    } else if (parent[u] != v) {
                        ans = Math.min(ans, dist[v] + dist[u] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}