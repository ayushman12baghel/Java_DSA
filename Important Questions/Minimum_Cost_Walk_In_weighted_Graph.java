import java.util.*;
import java.util.LinkedList;

public class Minimum_Cost_Walk_In_weighted_Graph {

    // Approach 1 Using Disjoint Set Union O(n+m+q)
    public static int[] minimumCost(int n, int edges[][], int query[][]) {
        int parent[] = new int[n];
        int rank[] = new int[n];
        int cost[] = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            cost[i] = Integer.MAX_VALUE;
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int parentU = find(u, parent);
            int parentV = find(v, parent);

            if (parentU != parentV) {
                union(parentU, parentV, parent, rank);
                int newParent = find(parentU, parent);
                cost[newParent] = cost[parentU] & cost[parentV] & w;
            }

            cost[parentU] &= w;
        }

        int ans[] = new int[query.length];
        for (int i = 0; i < ans.length; i++) {
            int start = query[i][0];
            int end = query[i][1];

            int parentStart = find(start, parent);
            int parentEnd = find(end, parent);

            if (parentStart == parentEnd) {
                ans[i] = cost[parentStart];
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public static int find(int i, int parent[]) {
        if (i == parent[i]) {
            return i;
        }

        return find(parent[i], parent);
    }

    public static void union(int x, int y, int parent[], int rank[]) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);

        if (parentX == parentY) {
            return;
        }

        if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }

    // Approach 2 Using BFS O(m+n+q)
    public static int[] minimumCost2(int n, int edges[][], int query[][]) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        boolean visited[] = new boolean[n];
        int componentId[] = new int[n];
        List<Integer> componentCosts = new ArrayList<>();
        int currentComponent = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                int cost = bfs(graph, node, visited, componentId, currentComponent);
                currentComponent++;
                componentCosts.add(cost);
            }
        }

        int ans[] = new int[query.length];

        for (int i = 0; i < ans.length; i++) {
            int start = query[i][0];
            int end = query[i][1];

            if (componentId[start] == componentId[end]) {
                ans[i] = componentCosts.get(componentId[start]);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public static int bfs(List<List<int[]>> graph, int node, boolean visited[], int componentId[],
            int currentComponent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        int currentCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            componentId[current] = currentComponent;

            for (int neighbour[] : graph.get(current)) {
                int neigh = neighbour[0];
                int weight = neighbour[1];

                currentCost &= weight;

                if (!visited[neigh]) {
                    queue.offer(neigh);
                    visited[neigh] = true;
                }
            }
        }

        return currentCost;
    }

    // Approach 3 Using DFS
    public static int dfs(List<List<int[]>> graph, int node, boolean visited[], int componentId[],
            int currentComponent) {
        componentId[node] = currentComponent;
        visited[node] = true;
        int cost = Integer.MAX_VALUE;

        for (int neighbour[] : graph.get(node)) {
            int neigh = neighbour[0];
            int weight = neighbour[1];
            cost &= weight;

            if (!visited[neigh]) {
                cost &= dfs(graph, neigh, visited, componentId, currentComponent);
            }
        }

        return cost;
    }

    public static void main(String args[]) {
        int n = 5;
        int edges[][] = { { 0, 1, 7 }, { 1, 3, 7 }, { 1, 2, 1 } };
        int query[][] = { { 0, 3 }, { 3, 4 } };

        int ans[] = minimumCost(n, edges, query);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        int ans2[] = minimumCost2(n, edges, query);

        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
