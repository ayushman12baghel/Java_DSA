import java.util.*;
import java.util.LinkedList;

public class Bfs_Traversal {

    // Normal BFS
    public static List<Character> bfs(int graph[][]) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean visited[] = new boolean[list.size()];
        visited[0] = true;
        List<Character> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add((char) (current + 'A'));

            for (int neighbour : list.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return result;
    }

    // Level Order Traversal BFS
    public static List<Character> levelOrderBFS(int graph[][]) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        queue.offer(0);
        visited[0] = true;
        List<Character> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                result.add((char) (current + 'A'));

                for (int neighbour : list.get(current)) {
                    if (!visited[neighbour]) {
                        queue.offer(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int[][] graph = {
                /*
                 * A —— B —— D
                 * | | |
                 * C E —— F
                 * 
                 */
                { 0, 1, 1, 0, 0, 0 }, // A (0)
                { 1, 0, 0, 1, 1, 0 }, // B (1)
                { 1, 0, 0, 0, 0, 0 }, // C (2)
                { 0, 1, 0, 0, 0, 1 }, // D (3)
                { 0, 1, 0, 0, 0, 1 }, // E (4)
                { 0, 0, 0, 1, 1, 0 }
        };
        int n = 4;

        List<Character> result = bfs(graph);
        System.out.println(result);

        System.out.println(levelOrderBFS(graph));
    }
}
