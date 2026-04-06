import java.util*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int obs[] : obstacles) {
            String key = obs[0] + "." + obs[1];
            set.add(key);
        }

        int x = 0;
        int y = 0;
        int maxDis = 0;

        int dir[] = { 0, 1 }; // North

        for (int num : commands) {
            if (num == -2) {
                dir = new int[] { -dir[1], dir[0] };
            } else if (num == -1) {
                dir = new int[] { dir[1], -dir[0] };
            } else {
                for (int step = 0; step < num; step++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String key = newX + "." + newY;
                    if (set.contains(key)) {
                        break;
                    }

                    x = newX;
                    y = newY;
                }
            }

            maxDis = Math.max(maxDis, x * x + y * y);
        }

        return maxDis;
    }
}