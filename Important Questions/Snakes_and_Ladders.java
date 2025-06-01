import java.util.*;
import java.util.LinkedList;

public class Snakes_and_Ladders {

    public static int snakesAndLadders(int board[][]) {
        int n = board.length;

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        queue.offer(1);
        visited[n - 1][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == n * n) {
                    return steps;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int next = dice + current;

                    if (next > n * n) {
                        break;
                    }

                    int coord[] = getCoord(next, n);
                    int row = coord[0];
                    int col = coord[1];

                    if (!visited[row][col]) {
                        visited[row][col] = true;
                        if (board[row][col] == -1) {
                            queue.offer(next);
                        } else {
                            queue.offer(board[row][col]);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public static int[] getCoord(int value, int n) {
        int row = n - 1 - (value - 1) / n;
        int col = (value - 1) % n;

        if (n % 2 == row % 2) {
            col = n - 1 - col;
        }

        return new int[] { row, col };
    }

    public static void main(String args[]) {
        int board[][] = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };

        System.out.println(snakesAndLadders(board));
    }
}
