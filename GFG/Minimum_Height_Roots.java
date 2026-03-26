import java.util.*;

// Approach 1 Using Diameter Logic O(n)
class Solution {
    public ArrayList<Integer> minHeightRoot(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int farthestFrom0[] = bfs(graph, 0);
        int farthestNodeA = getFarthest(farthestFrom0);

        int farthestFromA[] = bfs(graph, farthestNodeA);
        int farthestNodeB = getFarthest(farthestFromA);

        int farthestFromB[] = bfs(graph, farthestNodeB);

        int minHeight = Integer.MAX_VALUE;
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = Math.max(farthestFromA[i], farthestFromB[i]);
            minHeight = Math.min(minHeight, temp);
            height[i] = temp;

        }

        for (int i = 0; i < n; i++) {
            if (height[i] == minHeight) {
                ans.add(i);
            }
        }

        return ans;
    }

    public int[] bfs(List<List<Integer>> graph, int start) {
        int dist[] = new int[graph.size()];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph.get(current)) {
                if (dist[neighbour] == -1) {
                    queue.offer(neighbour);
                    dist[neighbour] = dist[current] + 1;
                }
            }
        }

        return dist;
    }

    public int getFarthest(int nums[]) {
        int maxDistance = -1;
        int node = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxDistance) {
                maxDistance = nums[i];
                node = i;
            }
        }

        return node;
    }
}

// Approach 2 Using indegree O(n)
class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (V == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[V];
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indeg[u]++;
            indeg[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = V;

        while (!queue.isEmpty() && remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbour : graph.get(current)) {
                    indeg[neighbour]--;

                    if (indeg[neighbour] == 1) {
                        queue.offer(neighbour);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }

        return ans;
    }
}