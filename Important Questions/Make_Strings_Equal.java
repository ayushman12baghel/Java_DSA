import java.util.*;

//Approach Using Dijkstra Algo O(n+m)
class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < transform.length; i++) {
            int x = transform[i][0] - 'a';
            int y = transform[i][1] - 'a';

            graph.get(x).add(new int[] { y, cost[i] });
        }

        int dist[][] = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            shortestPath(graph, i, dist[i]);
        }

        int totalCost = 0;

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';

            int best = Integer.MAX_VALUE;

            for (int k = 0; k < 26; k++) {
                if (dist[a][k] < Integer.MAX_VALUE && dist[b][k] < Integer.MAX_VALUE) {
                    best = Math.min(best, dist[a][k] + dist[b][k]);
                }
            }

            if (best == Integer.MAX_VALUE) {
                return -1;
            }

            totalCost += best;
        }

        return totalCost;
    }

    public void shortestPath(List<List<int[]>> graph, int start, int dist[]) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { start, 0 });
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int nextNode = neighbour[0];
                int newCost = cost + neighbour[1];

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[] { nextNode, newCost });
                }
            }
        }
    }
}
