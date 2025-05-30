import java.util.*;
import java.util.LinkedList;

public class Find_Closest_Node_to_given_Two_Nodes {

    // Using BFS O(n)
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) {
                continue;
            }

            graph.get(i).add(edges[i]);
        }

        int fromNode1[] = new int[n];
        Arrays.fill(fromNode1, -1);

        bfs(graph, node1, fromNode1);

        int fromNode2[] = new int[n];
        Arrays.fill(fromNode2, -1);

        bfs(graph, node2, fromNode2);

        int minNode = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (fromNode1[i] != -1 && fromNode2[i] != -1) {
                int maxDistance = Math.max(fromNode1[i], fromNode2[i]);
                if (maxDistance < minDistance) {
                    minDistance = maxDistance;
                    minNode = i;
                }
            }
        }

        return minNode;
    }

    public static void bfs(List<List<Integer>> graph, int start, int dist[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph.get(current)) {
                if (dist[neighbour] == -1) {
                    queue.offer(neighbour);
                    dist[neighbour] = dist[current] + 1;
                }
            }
        }
    }

    public static void main(String args[]) {
        int edges[] = { 2, 2, 3, -1 };
        int node1 = 0;
        int node2 = 1;

        System.out.println(closestMeetingNode(edges, node1, node2));
    }
}
