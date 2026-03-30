import java.util.*;

//Approach 1 Using Prim's Algorithm
class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = houses[i][0];
                int y1 = houses[i][1];

                int x2 = houses[j][0];
                int y2 = houses[j][1];

                int diff = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                graph.get(i).add(new int[] { j, diff });
                graph.get(j).add(new int[] { i, diff });
            }
        }

        return primsAlgo(graph, n);
    }

    public int primsAlgo(List<List<int[]>> graph, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean visited[] = new boolean[n];
        pq.offer(new int[] { 0, 0 });
        int cost = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (visited[node]) {
                continue;
            }

            cost += weight;
            visited[node] = true;

            for (int neighbour[] : graph.get(node)) {
                int newNode = neighbour[0];

                if (!visited[newNode]) {
                    int newCost = neighbour[1];
                    pq.offer(new int[] { newNode, newCost });
                }
            }
        }

        return cost;
    }
}

// More Optimised Prim's Algo O(n^2logn) and O(n) average case Space
class Solution {
    public int minCostConnectPoints(int[][] houses) {
        int n = houses.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int minDist[] = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean visited[] = new boolean[n];
        pq.offer(new int[] { 0, 0 });
        minDist[0] = 0;
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            totalCost += cost;
            visited[node] = true;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int diff = Math.abs(houses[node][0] - houses[next][0]) +
                            Math.abs(houses[node][1] - houses[next][1]);

                    if (diff < minDist[next]) {
                        minDist[next] = diff;
                        pq.offer(new int[] { next, diff });
                    }
                }
            }
        }

        return totalCost;
    }
}

// Opimal Prim's Algo O(n^2)
class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;

        int minDist[] = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean visited[] = new boolean[n];
        int totalCost = 0;
        minDist[0] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            totalCost += minDist[u];
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int diff = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    minDist[v] = Math.min(minDist[v], diff);
                }
            }
        }

        return totalCost;
    }
}
