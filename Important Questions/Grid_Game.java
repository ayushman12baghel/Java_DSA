import java.util.*;

public class Grid_Game {

    public static long gridGame(int[][] grid) {
        long firstRemainSum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            firstRemainSum += grid[0][i];
        }
        long secondRemaining = 0;
        long minRobot2Sum = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            firstRemainSum -= grid[0][i];
            minRobot2Sum = Math.min(minRobot2Sum, Math.max(firstRemainSum, secondRemaining));
            secondRemaining += grid[1][i];
        }

        return minRobot2Sum;
    }

    public static void main(String args[]) {
        int grid[][] = { { 1, 3, 1, 15 }, { 1, 3, 3, 1 } };
        System.out.println(gridGame(grid));
    }
}
