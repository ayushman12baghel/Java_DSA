import java.util.*;

// O(8^(n*n))
class Solution {
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                ans.get(i).add(-1);
            }
        }

        ans.get(0).set(0, 0);
        solve(n, 0, 0, 1, ans);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ans.get(i).get(j) == -1) {
                    ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
                    temp.add(new ArrayList<>());
                    temp.get(0).add(-1);

                    return temp;
                }
            }
        }

        return ans;
    }

    private int directions[][] = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -1, -2 }, { -2, -1 }, { 1, -2 },
            { 2, -1 } };

    public boolean solve(int n, int row, int col, int move, ArrayList<ArrayList<Integer>> ans) {
        if (move == n * n) {
            return true;
        }

        for (int direction[] : directions) {
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;

            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && ans.get(newRow).get(newCol) == -1) {
                ans.get(newRow).set(newCol, move);
                if (solve(n, newRow, newCol, move + 1, ans)) {
                    return true;
                }

                ans.get(newRow).set(newCol, -1);
            }
        }

        return false;
    }
}