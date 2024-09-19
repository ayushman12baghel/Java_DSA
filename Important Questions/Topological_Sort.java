import java.util.*;
import java.util.LinkedList;

public class Topological_Sort {
    static void createGraph(ArrayList<ArrayList<Integer>> graph) { // O(V+E)
        // Adding edges
        graph.get(2).add(3); // Edge 2 -> 3
        graph.get(3).add(1); // Edge 3 -> 1
        graph.get(4).add(0); // Edge 4 -> 0
        graph.get(4).add(1); // Edge 4 -> 1
        graph.get(5).add(0); // Edge 5 -> 0
        graph.get(5).add(2); // Edge 5 -> 2
    }

    public static int[] topSort(ArrayList<ArrayList<Integer>> graph) {
        boolean vis[] = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, stack);
            }
        }

        int ans[] = new int[graph.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }

        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;
        for (int i = 0; i < graph.get(curr).size(); i++) {
            int temp = graph.get(curr).get(i);
            if (!vis[temp]) {
                dfs(graph, temp, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void calcIndeg(ArrayList<ArrayList<Integer>> graph, int indeg[]) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int temp = graph.get(i).get(j);
                indeg[temp]++;
            }
        }
    }

    public static int[] topSortBFS(ArrayList<ArrayList<Integer>> graph) {
        int indeg[] = new int[graph.size()];
        calcIndeg(graph, indeg);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        int ans[] = new int[indeg.length];

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans[index++] = curr;
            for (int i = 0; i < graph.get(curr).size(); i++) {
                int neighbour = graph.get(curr).get(i);
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        createGraph(graph);
        int ans[] = topSort(graph);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        int ans2[] = topSortBFS(graph);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
