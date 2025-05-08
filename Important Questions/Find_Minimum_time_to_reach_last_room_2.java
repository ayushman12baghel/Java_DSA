import java.util.*;

public class Find_Minimum_time_to_reach_last_room_2 {

    // By putting moveTime in PriorityQueue only
    public static int minTimeToReach(int moveTime[][]) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean visited[][] = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0, 1 });
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            int move = current[3];

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
                    int newTime = Math.max(time + move, moveTime[newRow][newCol] + move);
                    pq.offer(new int[] { newRow, newCol, newTime, move == 1 ? 2 : 1 });

                }
            }
        }

        return -1;
    }

    // By calculating MoveTime
    public static int minTimeToReach2(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean visited[][] = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0 });
        int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

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
                int move = (newRow + newCol) % 2 == 0 ? 2 : 1;

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && !visited[newRow][newCol]) {
                    int newTime = Math.max(time + move, moveTime[newRow][newCol] + move);
                    pq.offer(new int[] { newRow, newCol, newTime });

                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int minTime[][] = { { 0, 4 }, { 4, 4 } };
        System.out.println(minTimeToReach(minTime));
        System.out.println(minTimeToReach2(minTime));
    }
}
