import java.util.*;

//Approach Using DSU O(V+E)
class DSU {
    int parent[];
    int size[];

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

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

    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return false;
        }

        if (size[parentX] > size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }

        return true;
    }
}

class Solution {
    public int minConnect(int V, int[][] edges) {
        DSU dsu = new DSU(V);
        int redundantEdges = 0;

        for (int edge[] : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                redundantEdges++;
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < V; i++) {
            set.add(dsu.find(i));
        }

        int requiredEdges = set.size() - 1;
        if (redundantEdges < requiredEdges) {
            return -1;
        }

        return requiredEdges;
    }
}
