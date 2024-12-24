import java.util.*;
import java.util.LinkedList;

public class Find_Minimum_Diameter_After_Merging_Two_Trees {

    public static int minimumDiameterAfterMerge(int edges1[][], int edges2[][]) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = buildAdj(edges1, n);
        List<List<Integer>> adj2 = buildAdj(edges2, m);

        int d1 = diameter(adj1);
        int d2 = diameter(adj2);
        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        return Math.max(d1, Math.max(d2, combined));
    }

    public static List<List<Integer>> buildAdj(int edges[][], int n) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        return list;
    }

    public static int diameter(List<List<Integer>> graph) {
        List<Integer> farthestNode = BFS(graph, 0);
        farthestNode = BFS(graph, farthestNode.get(0));

        return farthestNode.get(1);
    }

    public static List<Integer> BFS(List<List<Integer>> graph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.size()];
        int farthestNode = source;
        int maxDistance = 0;

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                farthestNode = currentNode;

                for (int neighbour : graph.get(currentNode)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }

            if (!queue.isEmpty()) {
                maxDistance++;
            }
        }

        return Arrays.asList(farthestNode, maxDistance);
    }

    public static void main(String args[]) {
        int edges1[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 2, 7 } };
        int edges2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 2, 7 } };

        System.out.println(minimumDiameterAfterMerge(edges1, edges2));
    }
}
