import java.util.*;
import java.util.LinkedList;

public class Course_Schedule_4 {

    // Tree Traversal - Preprocessed
    public static List<Boolean> checkIfPrerequisite(int numCourses, int prerequisites[][], int queries[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Boolean> ans = new ArrayList<>();
        boolean canReach[][] = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            bfs(graph, canReach, i, numCourses);
        }

        for (int query[] : queries) {
            ans.add(canReach[query[0]][query[1]]);
        }

        return ans;
    }

    public static void bfs(List<List<Integer>> graph, boolean canReach[][], int start, int numCourses) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[numCourses];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    canReach[start][neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    // Topological Sort - Kahn's Algorithm
    public static List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        boolean canReach[][] = new boolean[numCourses][numCourses];
        int indeg[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            list.get(pre[0]).add(pre[1]);
            indeg[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : list.get(current)) {
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
                canReach[current][neighbour] = true;

                for (int i = 0; i < numCourses; i++) {
                    if (canReach[i][current]) {
                        canReach[i][neighbour] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int query[] : queries) {
            ans.add(canReach[query[0]][query[1]]);
        }

        return ans;
    }

    public static List<Boolean> checkIfPrerequisite3(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        int indeg[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            list.get(pre[0]).add(pre[1]);
            indeg[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<HashSet<Integer>> canReach = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            canReach.add(new HashSet<>());
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : list.get(current)) {
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
                canReach.get(neighbour).add(current);
                canReach.get(neighbour).addAll(canReach.get(current));
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int query[] : queries) {
            ans.add(canReach.get(query[1]).contains(query[0]));
        }

        return ans;
    }

    public static void main(String args[]) {
        int numCourses = 3;
        int prerequisites[][] = { { 1, 2 }, { 1, 0 }, { 2, 0 } };
        int queries[][] = { { 1, 0 }, { 1, 2 } };

        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
        System.out.println(checkIfPrerequisite2(numCourses, prerequisites, queries));
        System.out.println(checkIfPrerequisite3(numCourses, prerequisites, queries));
    }
}
