import java.util.*;
import java.util.LinkedList;

public class Course_Schedule {

    public static boolean canFinish(int prerequistics[][], int numCourses) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int pre[] : prerequistics) {
            list.get(pre[1]).add(pre[0]);
        }
        boolean vis[] = new boolean[list.size()];
        boolean stack[] = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (!vis[i]) {
                if (isCycle(list, i, vis, stack)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> list, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < list.get(curr).size(); i++) {
            int temp = list.get(curr).get(i);
            if (stack[temp]) {
                return true;
            }
            if (!vis[temp] && isCycle(list, temp, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;

        return false;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
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
            return true;
        }

        return false;
    }

    public static void calcIndeg(ArrayList<ArrayList<Integer>> graph, int indeg[]) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int temp = graph.get(i).get(j);
                indeg[temp]++;
            }
        }
    }

    public static void main(String args[]) {
        int prerequistics[][] = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        int numCourses = 4;

        System.out.println(canFinish(prerequistics, numCourses));
        System.out.println(canFinish2(numCourses, prerequistics));
    }
}
