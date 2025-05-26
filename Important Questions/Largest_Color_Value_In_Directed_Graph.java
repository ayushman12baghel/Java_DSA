import java.util.*;
import java.util.LinkedList;

public class Largest_Color_Value_In_Directed_Graph {

    // Using topological Sortingf
    public static int largestPathValue(String colors, int edges[][]) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int dp[][] = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
                dp[i][colors.charAt(i) - 'a']++;
            }
        }

        int ans = 0;
        int countNodes = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            countNodes++;

            ans = Math.max(ans, dp[current][colors.charAt(current) - 'a']);

            for (int neighbour : graph.get(current)) {
                for (int i = 0; i < 26; i++) {

                    dp[neighbour][i] = Math.max(dp[neighbour][i],
                            dp[current][i] + (colors.charAt(neighbour) - 'a' == i ? 1 : 0));
                }

                indeg[neighbour]--;

                if (indeg[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return countNodes == n ? ans : -1;
    }

    public static void main(String args[]) {
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
        String colors = "abaca";

        System.out.println(largestPathValue(colors, edges));
    }
}
