import java.util.*;

public class Number_of_Ways_To_Arrive_at_Destination {

    // Using DIjkstra Algorithm
    public static int countPaths(int n, int roads[][]) {
        int MOD = 1000000007;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int road[] : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        long dest[] = new long[n];
        long pathCount[] = new long[n];
        Arrays.fill(dest, Long.MAX_VALUE);
        dest[0] = 0;
        pathCount[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long curr[] = pq.poll();
            int u = (int) curr[0];
            long w = curr[1];

            if (w < dest[u]) {
                continue;
            }

            for (int neighbour[] : graph.get(u)) {
                int neigh = neighbour[0];
                long weight = neighbour[1];

                if (w + weight < dest[neigh]) {
                    dest[neigh] = w + weight;
                    pq.offer(new long[] { neigh, dest[neigh] });
                    pathCount[neigh] = pathCount[u];
                } else if (w + weight == dest[neigh]) {
                    pathCount[neigh] = (pathCount[neigh] + pathCount[u]) % MOD;
                }
            }
        }

        return (int) pathCount[n - 1];
    }

    public static void main(String args[]) {
        int n = 7;
        int roads[][] = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };

        System.out.println(countPaths(n, roads));
    }
}
