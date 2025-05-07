import java.util.*;

public class Find_Minimum_Time_to_Reach_Room_I {

    // Using Dijkstra's A;gorithm
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        boolean visited[][] = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];

            if (row == n - 1 && col == m - 1) {
                return time;
            }

            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            for (int direction[] : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                    int newTime = Math.max(time + 1, moveTime[newRow][newCol] + 1);
                    pq.offer(new int[] { newRow, newCol, newTime });
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int moveTime[][] = { { 0, 4 }, { 4, 4 } };

        System.out.println(minTimeToReach(moveTime));
    }
}
