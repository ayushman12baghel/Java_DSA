import java.util.*;
import java.util.LinkedList;

public class Divide_Nodes_into_maximum_number_of_Groups {

    public static int magnificentSets(int edges[][], int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int colors[] = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !isBipartite(graph, i, n, colors)) {
                return -1;
            }
        }

        int levels[] = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = bfs(graph, i, n);
        }

        boolean visited[] = new boolean[n];
        int maxGroups = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                maxGroups += findGroups(graph, i, visited, levels);
            }
        }

        return maxGroups;
    }

    public static boolean isBipartite(List<List<Integer>> graph, int i, int n, int colors[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        colors[i] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph.get(current)) {
                if (colors[neighbour] == -1) {
                    colors[neighbour] = colors[current] == 0 ? 1 : 0;
                    queue.offer(neighbour);
                } else if (colors[neighbour] == colors[current]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int bfs(List<List<Integer>> graph, int i, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.offer(i);
        visited[i] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }

            level++;
        }

        return level;
    }

    public static int findGroups(List<List<Integer>> graph, int i, boolean visited[], int levels[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        int max = levels[i];

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int current = queue.poll();
                max = Math.max(levels[current], max);

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int n = 6;
        int edges[][] = { { 1, 2 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 3 }, { 4, 6 } };

        System.out.println(magnificentSets(edges, n));
    }
}
