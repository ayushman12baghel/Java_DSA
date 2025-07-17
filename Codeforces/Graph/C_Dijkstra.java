import java.util.*;
import java.io.*;

public class C_Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine[] = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String parts[] = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        long dist[] = new long[n + 1];
        int parent[] = new int[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[] { 1, 0 });

        while (!pq.isEmpty()) {
            long current[] = pq.poll();
            int node = (int) current[0];
            long weight = current[1];

            if (dist[node] < weight) {
                continue;
            }

            for (int neighbour[] : graph.get(node)) {
                int v = neighbour[0];
                int w = neighbour[1];

                if (dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                    parent[v] = node;
                    pq.offer(new long[] { v, dist[v] });
                }
            }
        }

        if (dist[n] == Long.MAX_VALUE) {
            System.out.println("-1");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int at = n; at != -1; at = parent[at]) {
                path.add(at);
            }
            Collections.reverse(path);
            for (int i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}