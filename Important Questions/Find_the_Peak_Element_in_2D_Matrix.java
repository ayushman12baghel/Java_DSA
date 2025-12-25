import java.util.*;

//O(n*m)
class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = grid[i][j];
                boolean possible = true;

                if (i > 0 && grid[i - 1][j] > current) {
                    possible = false;
                }
                if (j > 0 && grid[i][j - 1] > current) {
                    possible = false;
                }
                if (i + 1 < grid.length && grid[i + 1][j] > current) {
                    possible = false;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] > current) {
                    possible = false;
                }

                if (possible) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);

                    return ans;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);

        return ans;
    }
}