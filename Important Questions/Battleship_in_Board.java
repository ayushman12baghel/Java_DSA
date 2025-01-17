import java.util.*;
import java.util.LinkedList;

public class Battleship_in_Board {

    // BFS
    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    bfs(board, i, j);
                }
            }
        }

        return count;
    }

    static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void bfs(char board[][], int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length
                            && board[newRow][newCol] == 'X') {
                        queue.offer(new int[] { newRow, newCol });
                        board[newRow][newCol] = '.';
                    }
                }
            }
        }
    }

    // DFS
    public static int countBattleships2(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(char board[][], int x, int y) {
        board[x][y] = '.';

        for (int direction[] : directions) {
            int row = direction[0] + x;
            int col = direction[1] + y;

            if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == 'X') {
                dfs(board, row, col);
            }
        }
    }

    public static void main(String args[]) {
        char board[][] = {
                { 'X', '.', '.', 'X' },
                { '.', '.', '.', 'X' },
                { '.', '.', '.', 'X' }
        };

        System.out.println(countBattleships2(board));
        System.out.println(countBattleships(board));
    }
}
