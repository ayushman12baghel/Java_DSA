import java.util.List;
import java.util.PriorityQueue;

public class MST_Prims_Algorithm {
    public static int spanningTree(int V, int E, List<List<int[]>> graph) {
        // Code Here.
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { 0, 0 });
        boolean visited[] = new boolean[V];

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            cost += weight;

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];
                int newWeight = neighbour[1];

                if (!visited[newNode]) {
                    pq.offer(new int[] { newNode, newWeight });
                }
            }
        }

        return cost;
    }
}
