import java.util.*;

public class Minimum_Edges {

    // Approach 1 Using Dijkstra Algo O(nlogm)
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src,
            int dst) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], 0 });
            graph.get(edge[1]).add(new int[] { edge[0], 1 });
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) {
                continue;
            }

            if (node == dst) {
                return cost;
            }

            for (int neighbour[] : graph.get(node)) {
                int newCost = neighbour[1] + cost;
                if (newCost < dist[neighbour[0]]) {
                    dist[neighbour[0]] = newCost;
                    pq.offer(new int[] { neighbour[0], newCost });
                }
            }
        }

        return -1;
    }

    // Approach 2 Using 0-1 BFS O(n+2m)
    public static int minimumEdgeReversal2(int[][] edges, int n, int m, int src,
            int dst) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], 0 });
            graph.get(edge[1]).add(new int[] { edge[0], 1 });
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] { src, 0 });

        while (!deque.isEmpty()) {
            int current[] = deque.pollFirst();
            int node = current[0];
            int cost = current[1];

            if (node == dst) {
                return cost;
            }

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int edgeCost = neighbour[1];
                int newCost = edgeCost + cost;

                if (newCost < dist[newNode]) {
                    if (edgeCost == 0) {
                        deque.offerFirst(new int[] { newNode, newCost });
                        dist[newNode] = newCost;
                    } else {
                        deque.offerLast(new int[] { newNode, newCost });
                        dist[newNode] = newCost;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 3;
        int M = 2;
        int edges[][] = { { 1, 2 }, { 3, 2 } };
        int src = 1;
        int dst = 3;

        System.out.println(minimumEdgeReversal(edges, N, M, src, dst));
        System.out.println(minimumEdgeReversal2(edges, N, M, src, dst));
    }
}
