package Codeforces.Graph;

import java.util.*;
import java.io.*;

public class Flight_Discount {
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
        }

        long dist[][] = new long[n + 1][2];
        for (long row[] : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        dist[1][0] = 0;
        pq.offer(new long[] { 1, 0, 0 });

        while (!pq.isEmpty()) {
            long current[] = pq.poll();
            int u = (int) current[0];
            long cost = current[1];
            int used = (int) current[2];

            if (cost > dist[u][used]) {
                continue;
            }

            for (int neighbour[] : graph.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];

                if (cost + w < dist[v][used]) {
                    dist[v][used] = cost + w;
                    pq.offer(new long[] { v, cost + w, used });
                }

                if (used == 0 && cost + w / 2 < dist[v][1]) {
                    dist[v][1] = cost + w / 2;
                    pq.offer(new long[] { v, cost + w / 2, 1 });
                }
            }
        }

        System.out.println(Math.min(dist[n][1], dist[n][0]));
    }
}