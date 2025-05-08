import java.util.*;

public class Valid_Arrangement_of_Pairs {

    // By Euler Path
    public static int[][] validArrangement(int pairs[][]) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int edge[] : pairs) {
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
        }

        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int current = stack.peek();

            if (graph.containsKey(current) && graph.get(current).size() > 0) {
                List<Integer> neighbours = graph.get(current);
                int lastIndex = neighbours.size() - 1;
                int neighbour = neighbours.get(lastIndex);
                neighbours.remove(lastIndex);
                stack.push(neighbour);
            } else {
                eulerPath.add(current);
                stack.pop();
            }
        }

        Collections.reverse(eulerPath);
        int ans[][] = new int[eulerPath.size() - 1][2];
        for (int i = 0; i < eulerPath.size() - 1; i++) {
            ans[i][0] = eulerPath.get(i);
            ans[i][1] = eulerPath.get(i + 1);
        }

        return ans;
    }

    public static void main(String args[]) {
        int pairs[][] = { { 5, 1 }, { 4, 5 }, { 11, 9 }, { 9, 4 } };

        int ans[][] = validArrangement(pairs);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
