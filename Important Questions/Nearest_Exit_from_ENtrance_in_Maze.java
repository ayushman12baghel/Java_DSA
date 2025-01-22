import java.util.LinkedList;
import java.util.Queue;

public class Nearest_Exit_from_ENtrance_in_Maze {

    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        queue.offer(new int[] { entrance[0], entrance[1] });
        maze[entrance[0]][entrance[1]] = '+';

        int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && maze[newRow][newCol] == '.') {
                        if ((newRow == 0 || newCol == 0 || newRow == n - 1 || newCol == m - 1)
                                && !(newRow == entrance[0] && newCol == entrance[1])) {
                            return count;
                        }

                        queue.offer(new int[] { newRow, newCol });
                        maze[newRow][newCol] = '+';
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        char maze[][] = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
        int entrance[] = { 1, 2 };

        System.out.println(nearestExit(maze, entrance));
    }
}
