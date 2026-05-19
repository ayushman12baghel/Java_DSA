import java.util.*;

//Approach Using Bfs O(n*m)
class Solution {
    public int minSteps(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        int dist[] = new int[1000];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.offer(new int[] { start, 0 });
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int value = current[0];
            int steps = current[1];

            for (int num : nums) {
                int next = (value * num) % 1000;
                int newStep = steps + 1;

                if (next == end) {
                    return newStep;
                }

                if (dist[next] > steps + 1) {
                    dist[next] = steps + 1;
                    queue.offer(new int[] { next, steps + 1 });
                }
            }
        }

        return -1;
    }
}