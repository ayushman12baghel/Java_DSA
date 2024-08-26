import java.util.*;

public class Jump_Game_3 {

    public static boolean canReachBFS(int arr[], int start) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        vis[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int index = q.remove();
            if (arr[index] == 0) {
                return true;
            }

            int forward = index + arr[index];
            int backward = index - arr[index];
            if (forward < n && !vis[forward]) {
                q.add(forward);
                vis[forward] = true;
            }
            if (backward > 0 && !vis[backward]) {
                q.add(backward);
                vis[backward] = true;
            }
        }

        return false;
    }

    public static boolean canReachDFS(int arr[], int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }

    public static boolean dfs(int arr[], int index, boolean vis[]) {
        if (index < 0 || index >= arr.length || vis[index]) {
            return false;
        }

        if (arr[index] == 0) {
            return true;
        }
        vis[index] = true;
        int forward = index + arr[index];
        int backward = index - arr[index];

        return dfs(arr, forward, vis) || dfs(arr, backward, vis);
    }

    public static void main(String args[]) {
        int arr[] = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;

        System.out.println(canReachBFS(arr, start));
        System.out.println(canReachDFS(arr, start));
    }
}
