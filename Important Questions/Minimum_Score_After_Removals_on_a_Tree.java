import java.util.*;

public class Minimum_Score_After_Removals_on_a_Tree {

    public static int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int subtreeXor[] = new int[n];
        int inTime[] = new int[n];
        int outTime[] = new int[n];
        int timer[] = new int[1];

        // root=0
        dfs(graph, nums, 0, -1, subtreeXor, inTime, outTime, timer);

        int result = Integer.MAX_VALUE;

        for (int u = 1; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int xor1;
                int xor2;
                int xor3;

                if (isAncestor(u, v, inTime, outTime)) {
                    xor1 = subtreeXor[v];
                    xor2 = subtreeXor[u] ^ xor1;
                    xor3 = subtreeXor[0] ^ xor1 ^ xor2;
                } else if (isAncestor(v, u, inTime, outTime)) {
                    xor1 = subtreeXor[u];
                    xor2 = subtreeXor[v] ^ xor1;
                    xor3 = subtreeXor[0] ^ xor1 ^ xor2;
                } else {
                    xor1 = subtreeXor[v];
                    xor2 = subtreeXor[u];
                    xor3 = subtreeXor[0] ^ xor1 ^ xor2;
                }

                result = Math.min(result, getScore(xor1, xor2, xor3));
            }
        }

        return result;
    }

    public static void dfs(List<List<Integer>> graph, int nums[], int node, int parent, int subtreeXor[], int inTime[],
            int outTime[], int timer[]) {
        subtreeXor[node] = nums[node];
        inTime[node] = timer[0]++;

        for (int neighbour : graph.get(node)) {
            if (neighbour != parent) {
                dfs(graph, nums, neighbour, node, subtreeXor, inTime, outTime, timer);
                subtreeXor[node] ^= subtreeXor[neighbour];
            }
        }

        outTime[node] = timer[0]++;
    }

    public static boolean isAncestor(int u, int v, int inTime[], int outTime[]) {
        return inTime[u] <= inTime[v] && outTime[u] >= outTime[v];
    }

    public static int getScore(int xor1, int xor2, int xor3) {
        int max = Math.max(xor1, Math.max(xor2, xor3));
        int min = Math.min(xor1, Math.min(xor2, xor3));

        return max - min;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 5, 4, 11 }, edges[][] = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
        System.out.println(minimumScore(nums, edges));
    }
}
