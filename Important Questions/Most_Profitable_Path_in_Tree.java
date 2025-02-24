import java.util.*;

public class Most_Profitable_Path_in_Tree {
    static int ans = Integer.MIN_VALUE;

    // Approach 1 Using DFS and DFS
    public static int mostProfitablePath(int edges[][], int bob, int amount[]) {
        int n = amount.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean visited[] = new boolean[n];
        int time = 0;
        Map<Integer, Integer> bobMap = new HashMap<>();
        DFSBob(graph, bob, bobMap, visited, time);

        visited = new boolean[n];
        int income = 0;
        DFSAlice(graph, 0, 0, visited, bobMap, amount, income);

        return ans;
    }

    public static boolean DFSBob(List<List<Integer>> graph, int node, Map<Integer, Integer> bobMap, boolean visited[],
            int time) {
        visited[node] = true;
        bobMap.put(node, time);

        if (node == 0) {
            return true;
        }

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (DFSBob(graph, neighbour, bobMap, visited, time + 1)) {
                    return true;
                }
            }
        }

        bobMap.remove(node);

        return false;
    }

    public static void DFSAlice(List<List<Integer>> graph, int node, int time, boolean visited[],
            Map<Integer, Integer> bobMap, int amount[], int income) {
        visited[node] = true;

        if (!bobMap.containsKey(node) || bobMap.get(node) > time) {
            income += amount[node];
        } else if (time == bobMap.get(node)) {
            income += amount[node] / 2;
        }

        if (graph.get(node).size() == 1 && node != 0) {
            ans = Math.max(ans, income);
        }

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                DFSAlice(graph, neighbour, time + 1, visited, bobMap, amount, income);
            }
        }
    }

    // Approach 2 Using DFS and BFS
    static int ans2 = Integer.MIN_VALUE;

    public static int mostProfitablePath2(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Map<Integer, Integer> bobMap = new HashMap<>();
        boolean visited[] = new boolean[n];
        int time = 0;
        DFSBob(graph, bob, bobMap, visited, time);

        visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 0 });

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            int node = curr[0];
            time = curr[1];
            int income = curr[2];
            visited[node] = true;

            if (!bobMap.containsKey(node) || bobMap.get(node) > time) {
                income += amount[node];
            } else if (bobMap.get(node) == time) {
                income += amount[node] / 2;
            }

            if (graph.get(node).size() == 1 && node != 0) {
                ans2 = Math.max(ans, income);
            }

            for (int neighbour : graph.get(node)) {
                if (!visited[neighbour]) {
                    queue.offer(new int[] { neighbour, time + 1, income });
                }
            }
        }

        return ans2;
    }

    public static void main(String args[]) {
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
        int bob = 3;
        int amount[] = { -2, 4, 2, -4, 6 };

        System.out.println(mostProfitablePath(edges, bob, amount));
        System.out.println(mostProfitablePath2(edges, bob, amount));
    }
}
