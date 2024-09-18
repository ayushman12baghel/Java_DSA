import java.util.*;
import java.util.LinkedList;

public class Rotting_Oranges {

    public static int rottingOranges(int grid[][]) {
        Queue<int[]> queue = new LinkedList<>();
        int minutes = 0;
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int directions[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        if (fresh == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int direction[] : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        rotten = true;
                        queue.offer(new int[] { newRow, newCol });
                        fresh--;
                    }
                }
            }
            if (rotten) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String args[]) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        System.out.println(rottingOranges(grid));

    }
}
