import java.util.*;
import java.util.LinkedList;

public class Find_Eventual_Safe_States {

    // DFS
    public static List<Integer> eventualSafeStates(int graph[][]) {
        boolean visited[] = new boolean[graph.length];
        boolean safe[] = new boolean[graph.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                isCycle(graph, visited, safe, i);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (!safe[i]) {
                list.add(i);
            }
        }

        return list;
    }

    public static boolean isCycle(int graph[][], boolean visited[], boolean safe[], int current) {
        safe[current] = true;
        visited[current] = true;

        for (int neighbour : graph[current]) {
            if (safe[neighbour]) {
                return true;
            } else if (!visited[neighbour] && isCycle(graph, visited, safe, neighbour)) {
                return true;
            }
        }
        safe[current] = false;

        return false;
    }

    // Using BFS Kahn's Algorithm
    public static List<Integer> eventualSafeNodes2(int[][] graph) {
        int n = graph.length;
        int indeg[] = new int[n];
        boolean safe[] = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                list.get(node).add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            safe[current] = true;

            for (int neighbour : list.get(current)) {
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

        System.out.println(eventualSafeStates(graph));
        System.out.println(eventualSafeNodes2(graph));
    }
}
