import java.util.*;

//Approach Using Dijkstra Algo O(n+m)
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < original.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';

            graph.get(x).add(new int[] { y, cost[i] });
        }

        long dist[][] = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            shortestPath(graph, i, dist[i]);
        }

        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';

            if (dist[a][b] == Long.MAX_VALUE) {
                return -1;
            }

            totalCost += dist[a][b];
        }

        return totalCost;
    }

    public void shortestPath(List<List<int[]>> graph, int start, long dist[]) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[] { start, 0 });
        dist[start] = 0;

        while (!pq.isEmpty()) {
            long current[] = pq.poll();
            int node = (int) current[0];
            long cost = current[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                long newCost = neighbour[1] + cost;

                if (newCost < dist[newNode]) {
                    dist[newNode] = newCost;
                    pq.offer(new long[] { newNode, newCost });
                }
            }
        }
    }
}