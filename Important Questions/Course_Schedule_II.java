import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Course_Schedule_II {

    // Bfs Kahn's Algorithm
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int pre[] : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        int indeg[] = new int[graph.size()];
        calcIndeg(graph, indeg);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);
            for (int i = 0; i < graph.get(curr).size(); i++) {
                int neighbour = graph.get(curr).get(i);
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        if (ans.size() == numCourses) {
            int ans2[] = new int[ans.size()];
            int i = 0;
            for (int num : ans) {
                ans2[i++] = num;
            }
            return ans2;
        }

        return new int[] {};
    }

    public static void calcIndeg(ArrayList<ArrayList<Integer>> graph, int indeg[]) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int temp = graph.get(i).get(j);
                indeg[temp]++;
            }
        }
    }

    // Using DFS
    public static int[] findOrder2(int numCourses, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = numCourses;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        boolean inRecursion[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, inRecursion, stack, i)) {
                    return new int[] {};
                }
            }
        }

        int result[] = new int[n];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

    public static boolean dfs(List<List<Integer>> graph, boolean visited[], boolean inRecursion[], Stack<Integer> stack,
            int curr) {
        visited[curr] = true;
        inRecursion[curr] = true;

        for (int neighbour : graph.get(curr)) {
            if (!visited[neighbour]) {
                if (dfs(graph, visited, inRecursion, stack, neighbour)) {
                    return true;
                }
            } else if (inRecursion[neighbour]) {
                return true;
            }
        }

        stack.push(curr);
        inRecursion[curr] = false;

        return false;
    }

    public static void main(String args[]) {
        int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int numCourses = 4;
        int ans[] = findOrder(numCourses, prerequisites);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        int ans2[] = findOrder2(numCourses, prerequisites);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
