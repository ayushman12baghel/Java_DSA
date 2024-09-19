import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_II {

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

    public static void main(String args[]) {
        int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int numCourses = 4;
        int ans[] = findOrder(numCourses, prerequisites);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
