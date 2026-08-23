import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        int[][] minUp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minUp[i], Integer.MAX_VALUE);
        }

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offerFirst(r * m + c);
        minUp[r][c] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();
            int currR = curr / m;
            int currC = curr % m;

            for (int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] != '#') {

                    int cost = (i == 0) ? 1 : 0;
                    int newU = minUp[currR][currC] + cost;

                    int newD = newU + (nr - r);

                    if (newU <= u && newD <= d && newU < minUp[nr][nc]) {
                        minUp[nr][nc] = newU;

                        if (cost == 1) {
                            deque.offerLast(nr * m + nc); 
                        } else {
                            deque.offerFirst(nr * m + nc);
                        }
                    }
                }
            }
        }
      
        int validCellsCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (minUp[i][j] != Integer.MAX_VALUE) {
                    validCellsCount++;
                }
            }
        }

        return validCellsCount;
    }
}
