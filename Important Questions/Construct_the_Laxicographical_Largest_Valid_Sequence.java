import java.util.*;

public class Construct_the_Laxicographical_Largest_Valid_Sequence {

    public static int[] constructDistancedSequence(int n) {
        int ans[] = new int[2 * n - 1];
        boolean visited[] = new boolean[n + 1];

        Arrays.fill(ans, -1);

        solve(ans, visited, 0, n);

        return ans;
    }

    public static boolean solve(int ans[], boolean visited[], int index, int n) {
        if (index >= ans.length) {
            return true;
        }

        if (ans[index] != -1) {
            return solve(ans, visited, index + 1, n);
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }

            ans[index] = i;
            visited[i] = true;

            if (i == 1) {
                if (solve(ans, visited, index + 1, n)) {
                    return true;
                }
            } else {
                int j = i + index;
                if (j < ans.length && ans[j] == -1) {
                    ans[j] = i;
                    if (solve(ans, visited, index + 1, n)) {
                        return true;
                    }
                    ans[j] = -1;
                }
            }

            visited[i] = false;
            ans[i] = -1;
        }

        return false;
    }

    public static void main(String args[]) {
        int ans[] = constructDistancedSequence(3);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
