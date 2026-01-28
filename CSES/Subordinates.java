package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Subordinates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int parent[] = new int[n];
        for (int i = 1; i < n; i++) {
            int boss = Integer.parseInt(st.nextToken()) - 1;
            graph[boss].add(i);
            parent[i] = boss;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int index = 0;
        int order[] = new int[n];

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[index++] = u;

            for (int v : graph[u]) {
                queue.offer(v);
            }
        }

        int subtree[] = new int[n];

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[u];
            subtree[p] += (subtree[u] + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(subtree[i]);
            sb.append(' ');
        }

        System.out.println(sb.toString());
    }
}
