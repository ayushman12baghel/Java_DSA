import java.util.*;
import java.util.LinkedList;

public class Diameter_of_Undirected_Graph {

    public static int graphDiameter(int edges[][]) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int edge[] : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return findDiameter(graph);
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

    public static void main(String args[]) {
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 4, 5 } };
        System.out.println(graphDiameter(edges));
    }
}
