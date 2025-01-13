import java.util.*;
import java.util.LinkedList;

public class Minimise_The_maximum_edge_weight_of_graph {

    // using BFS
    public static int minMaxWeight(int[][] edges, int n, int threshold) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int maxWeight = 0;

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(v).add(new int[] { u, w });
            maxWeight = Math.max(maxWeight, w);
        }

        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = maxWeight;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReach(graph, n, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    public static boolean canReach(ArrayList<ArrayList<int[]>> graph, int n, int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean visited[] = new boolean[n];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int temp[] : graph.get(current)) {
                    int v = temp[0];
                    int w = temp[1];
                    if (w <= mid && !visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
        }
        for (boolean vis : visited) {
            if (!vis) {
                return false;
            }
        }

        return true;
    }

    // dfs
    public static boolean canReach(ArrayList<ArrayList<int[]>> graph, int n, int mid) {
        boolean visited[] = new boolean[n];
        dfs(graph, 0, mid, visited);
        for (boolean vis : visited) {
            if (!vis) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(ArrayList<ArrayList<int[]>> graph, int current, int mid, boolean visited[]) {
        visited[current] = true;
        for (int temp[] : graph.get(current)) {
            int v = temp[0];
            int w = temp[1];
            if (w <= mid && !visited[v]) {
                visited[v] = true;
                dfs(graph, v, mid, visited);
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        int edges[][] = { { 1, 0, 1 }, { 2, 0, 2 }, { 3, 0, 1 }, { 4, 3, 1 }, { 2, 1, 1 } };
        int threshold = 2;

        System.out.println(minMaxWeight(edges, n, threshold));
    }
}
