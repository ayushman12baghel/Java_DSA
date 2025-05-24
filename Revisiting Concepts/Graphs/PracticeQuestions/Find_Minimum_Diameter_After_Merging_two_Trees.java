import java.util.*;

public class Find_Minimum_Diameter_After_Merging_two_Trees {

    // Approach 1 -> Using Map as graph
    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        if (edges1.length == 0 && edges2.length == 0) {
            return 1;
        }
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        Map<Integer, List<Integer>> graph2 = new HashMap<>();

        for (int edge[] : edges1) {
            graph1.putIfAbsent(edge[0], new ArrayList<>());
            graph1.putIfAbsent(edge[1], new ArrayList<>());
            graph1.get(edge[0]).add(edge[1]);
            graph1.get(edge[1]).add(edge[0]);
        }
        for (int edge[] : edges2) {
            graph2.putIfAbsent(edge[1], new ArrayList<>());
            graph2.putIfAbsent(edge[0], new ArrayList<>());
            graph2.get(edge[0]).add(edge[1]);
            graph2.get(edge[1]).add(edge[0]);
        }

        int diameter1 = graph1.isEmpty() ? 0 : findDiameter(graph1);
        int diameter2 = graph2.isEmpty() ? 0 : findDiameter(graph2);

        int combined = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;

        return Math.max(diameter1, Math.max(diameter2, combined));
    }

    public static int findDiameter(Map<Integer, List<Integer>> graph) {
        int farthestNode[] = findFarthestNode(graph, 0);
        int diameter[] = findFarthestNode(graph, farthestNode[0]);

        return diameter[1];
    }

    public static int[] findFarthestNode(Map<Integer, List<Integer>> graph, int src) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(src);
        visited.add(src);
        int maxDistance = 0;
        int farthestNode = src;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                farthestNode = current;

                for (int neighbour : graph.get(current)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }

            if (!queue.isEmpty()) {
                maxDistance++;
            }
        }

        return new int[] { farthestNode, maxDistance };
    }

    // Approach 2 -> Using List as Graph
    public static int minimumDiameterAfterMerge2(int[][] edges1, int[][] edges2) {
        if (edges1.length == 0 && edges2.length == 0) {
            return 1;
        }

        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<List<Integer>> graph1 = new ArrayList<>();
        List<List<Integer>> graph2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph2.add(new ArrayList<>());
        }

        for (int edge[] : edges1) {
            graph1.get(edge[0]).add(edge[1]);
            graph1.get(edge[1]).add(edge[0]);
        }
        for (int edge[] : edges2) {
            graph2.get(edge[0]).add(edge[1]);
            graph2.get(edge[1]).add(edge[0]);
        }

        int diameter1 = graph1.size() == 0 ? 0 : findDiameter(graph1, n);
        int diameter2 = graph2.size() == 0 ? 0 : findDiameter(graph2, m);

        int combined = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;

        return Math.max(diameter1, Math.max(diameter2, combined));
    }

    public static int findDiameter(List<List<Integer>> graph, int n) {
        int farthestNode[] = findFarthestNode(graph, 0, n);
        int diameter[] = findFarthestNode(graph, farthestNode[0], n);

        return diameter[1];
    }

    public static int[] findFarthestNode(List<List<Integer>> graph, int src, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.offer(src);
        visited[src] = true;
        int maxDistance = 0;
        int farthestNode = src;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                farthestNode = current;

                for (int neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }

            if (!queue.isEmpty()) {
                maxDistance++;
            }
        }

        return new int[] { farthestNode, maxDistance };
    }

    public static void main(String args[]) {
        int edges1[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int edges2[][] = { { 0, 1 } };
        System.out.println(minimumDiameterAfterMerge(edges1, edges2));
        System.out.println(minimumDiameterAfterMerge2(edges1, edges2));
    }
}
