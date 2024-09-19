import java.util.*;

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

    public static void main(String args[]) {
        int prerequistics[][] = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        int numCourses = 4;

        System.out.println(canFinish(prerequistics, numCourses));
    }
}
