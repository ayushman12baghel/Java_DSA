import java.uil.*;

// Approach Using Kahn's Algo O(n)
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int relation[] : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;
            graph.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int maxTime[] = new int[n];
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
                maxTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    maxTime[neighbour] = Math.max(maxTime[neighbour], maxTime[current] + time[neighbour]);
                    indeg[neighbour]--;
                    if (indeg[neighbour] == 0) {
                        queue.offer(neighbour);
                    }
                }
            }
        }

        int minTime = 0;
        for (int i = 0; i < n; i++) {
            minTime = Math.max(minTime, maxTime[i]);
        }

        return minTime;
    }
}