import java.util.*;

// Approach Using Backtracking O(n!) but somewhat optimised
class Solution {
    public int countArrangement(int n) {
        int ans[] = new int[1];
        solve(n, 1, new boolean[n + 1], ans);

        return ans[0];
    }

    public void solve(int n, int pos, boolean visited[], int ans[]) {
        if (pos > n) {
            ans[0]++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                solve(n, pos + 1, visited, ans);
                visited[i] = false;
            }
        }
    }
}