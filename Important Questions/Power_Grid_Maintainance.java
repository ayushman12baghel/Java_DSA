import java.util.*;

//Approach 1 Using DFS O((c+E+Q)⋅logc)
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[c + 1];
        int componentOf[] = new int[c + 1];
        Map<Integer, TreeSet<Integer>> componentStations = new HashMap<>();

        for (int node = 1; node <= c; node++) {
            if (!visited[node]) {
                dfs(graph, node, node, visited, componentOf, componentStations);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int query[] : queries) {
            int type = query[0];
            int x = query[1];

            int compId = componentOf[x];
            TreeSet<Integer> set = componentStations.get(compId);

            if (type == 1) {
                if (set.contains(x)) {
                    result.add(x);
                } else if (!set.isEmpty()) {
                    result.add(set.first());
                } else {
                    result.add(-1);
                }
            } else {
                set.remove(x);
            }
        }

        int ans[] = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public void dfs(List<List<Integer>> graph, int current, int compId, boolean visited[], int componentOf[],
            Map<Integer, TreeSet<Integer>> componentStations) {
        visited[current] = true;
        componentOf[current] = compId;

        componentStations.putIfAbsent(compId, new TreeSet<>());
        componentStations.get(compId).add(current);

        for (int neighbour : graph.get(current)) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, compId, visited, componentOf, componentStations);
            }
        }
    }
}

// Approach 2 BFS O((c+E+Q)⋅logc)
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
        }

        for (int edge[] : connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[c + 1];
        int componentOf[] = new int[c + 1];
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            if (!visited[i]) {
                bfs(graph, i, i, visited, componentOf, compMap);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int query[] : queries) {
            int type = query[0];
            int x = query[1];
            int componentId = componentOf[x];

            TreeSet<Integer> set = compMap.get(componentId);

            if (type == 1) {
                if (set.contains(x)) {
                    result.add(x);
                } else if (!set.isEmpty()) {
                    result.add(set.first());
                } else {
                    result.add(-1);
                }
            } else {
                set.remove(x);
            }
        }

        int ans[] = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public void bfs(List<List<Integer>> graph, int node, int compId, boolean visited[], int componentOf[],
            Map<Integer, TreeSet<Integer>> compMap) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        componentOf[node] = compId;
        compMap.computeIfAbsent(compId, k -> new TreeSet<>()).add(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                    componentOf[neighbour] = compId;
                    compMap.get(compId).add(neighbour);
                }
            }
        }
    }
}

// Approach 3 Using DSU O(Q⋅(logc+α(c)))≈O(Qlogc)
class DSU {
    int parent[];
    int size[];

    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return;
        }

        if (size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
    }
}

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();

        for (int i = 1; i <= c + 1; i++) {
            compMap.computeIfAbsent(i, k -> new TreeSet<>()).add(i);
        }

        for (int edge[] : connections) {
            int u = edge[0];
            int v = edge[1];

            int rootU = dsu.find(u);
            int rootV = dsu.find(v);

            if (rootU != rootV) {
                TreeSet<Integer> setU = compMap.get(rootU);
                TreeSet<Integer> setV = compMap.get(rootV);

                if (setU.size() > setV.size()) {
                    setU.addAll(setV);
                    dsu.union(u, v);
                    compMap.remove(rootV);
                } else {
                    setV.addAll(setU);
                    dsu.union(u, v);
                    compMap.remove(rootU);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int query[] : queries) {
            int type = query[0];
            int x = query[1];

            int componentId = dsu.find(x);
            TreeSet<Integer> set = compMap.get(componentId);

            if (type == 1) {
                if (set.contains(x)) {
                    result.add(x);
                } else if (!set.isEmpty()) {
                    result.add(set.first());
                } else {
                    result.add(-1);
                }
            } else {
                set.remove(x);
            }
        }

        int ans[] = new int[result.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}