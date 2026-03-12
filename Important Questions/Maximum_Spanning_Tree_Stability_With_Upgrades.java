import java.util.*;

// Approach DSU + Binary Search on Ans O(Elog(S))
class Solution {
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

    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int must = edge[3];

            if (must == 1) {
                if (dsu.union(u, v) == false) {
                    return -1;
                }
            }
        }

        int left = 0;
        int right = 200000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(n, edges, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossible(int n, int edges[][], int k, int mid) {
        DSU dsu = new DSU(n);
        List<int[]> upgradedCandidates = new ArrayList<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid) {
                    return false;
                }

                dsu.union(u, v);
            } else {
                if (s >= mid) {
                    dsu.union(u, v);
                } else if (2 * s >= mid) {
                    upgradedCandidates.add(new int[] { u, v });
                }
            }
        }

        for (int edge[] : upgradedCandidates) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) != dsu.find(v)) {
                if (k <= 0) {
                    return false;
                }

                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);

        for (int node = 1; node < n; node++) {
            if (dsu.find(node) != root) {
                return false;
            }
        }

        return true;
    }
}