import java.util.*;

public class Queens_That_Can_Attack_the_King {

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        int grid[][] = new int[8][8];

        for (int queen[] : queens) {
            int i = queen[0];
            int j = queen[1];
            grid[i][j] = 2;
        }

        int i = king[0];
        int j = king[1];

        // top
        while (i >= 0) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            i--;
        }

        // bottom
        i = king[0];
        while (i < grid.length) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            i++;
        }

        // left
        i = king[0];
        j = king[1];
        while (j >= 0) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            j--;
        }

        // right
        j = king[1];
        while (j < grid[0].length) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            j++;
        }

        // top left
        i = king[0];
        j = king[1];
        while (i >= 0 && j >= 0) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            i--;
            j--;
        }
        // top right
        i = king[0];
        j = king[1];
        while (i >= 0 && j < grid[0].length) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            i--;
            j++;
        }
        // down left
        i = king[0];
        j = king[1];
        while (i < grid.length && j >= 0) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            i++;
            j--;
        }
        // top left
        i = king[0];
        j = king[1];
        while (i < grid.length && j < grid[0].length) {
            if (grid[i][j] == 2) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                break;
            }
            i++;
            j++;
        }

        return ans;
    }

    public static void main(String args[]) {
        int queens[][] = { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 4 }, { 3, 5 }, { 4, 4 }, { 4, 5 } };
        int king[] = { 3, 3 };

        System.out.println(queensAttacktheKing(queens, king));
    }
}
