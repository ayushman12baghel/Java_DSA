import java.util.*;
import java.util.LinkedList;

public class Cycle_Detection_Directed {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.wt = w;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {// O(V+E)

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 2, 1));

        // 1-vertex
        graph[1].add(new Edge(1, 0, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 0, 1));
    }

    // DFS
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {// cycle
                return true;
            }

            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;

        return false;
    }

    // BFS
    public static boolean isCycle2(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && isCycleUtil(graph, i, visited)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int current, boolean visited[]) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { current, -1 });
        visited[current] = true;

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            int node = temp[0];
            int parent = temp[1];

            for (Edge e : graph[node]) {
                int neighbour = e.dest;

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new int[] { neighbour, node });
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        System.out.println(isCycle(graph));
        System.out.println(isCycle2(graph));
    }
}
