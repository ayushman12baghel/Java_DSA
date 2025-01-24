import java.util.*;

public class Find_Eventual_Safe_States {

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

    public static void main(String args[]) {
        int graph[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

        System.out.println(eventualSafeStates(graph));
    }
}
