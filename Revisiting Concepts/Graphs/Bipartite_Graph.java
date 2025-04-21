import java.util.*;
import java.util.LinkedList;

public class Bipartite_Graph {

    // BFS O(V+E)
    public static boolean isBipartite(int graph[][]) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int neighbour : graph[i]) {
                list.get(i).add(neighbour);
            }
        }

        int color[] = new int[graph.length];

        for (int start = 0; start < graph.length; start++) {
            if (color[start] != 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            color[start] = -1;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                int currentColor = color[current];

                for (int neighbour : list.get(current)) {
                    if (color[neighbour] == currentColor) {
                        return false;
                    }

                    if (color[neighbour] == 0) {
                        color[neighbour] = (currentColor == -1 ? 1 : -1);
                        queue.offer(neighbour);
                    }
                }
            }
        }

        return true;
    }

    // DFS O(V+E)
    public static boolean isBipartite2(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int neighbour : graph[i]) {
                list.get(i).add(neighbour);
            }
        }

        int color[] = new int[graph.length];

        for (int start = 0; start < graph.length; start++) {
            if (color[start] != 0) {
                continue;
            }

            color[start] = -1;

            if (!DFS(list, color, start)) {
                return false;
            }
        }

        return true;
    }

    public static boolean DFS(List<List<Integer>> graph, int color[], int start) {
        int currentColor = color[start];
        for (int neighbour : graph.get(start)) {
            if (color[neighbour] == currentColor) {
                return false;
            }

            if (color[neighbour] == 0) {
                color[neighbour] = (currentColor == -1 ? 1 : -1);
                if (!DFS(graph, color, neighbour)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int graph[][] = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
        System.out.println(isBipartite2(graph));
    }
}
