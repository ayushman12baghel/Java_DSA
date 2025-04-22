import java.util.*;

public class Number_of_Operations_to_make_Network_Connected {

    static class DSU {
        int parent[];
        int rank[];

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
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

            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
                rank[parentX]++;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
                rank[parentY]++;
            } else {
                parent[parentX] = parentY;
                rank[parentY]++;
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int components = n;
        DSU dsu = new DSU(n);

        for (int row[] : connections) {
            if (dsu.find(row[0]) == dsu.find(row[1])) {
                continue;
            } else {
                dsu.union(row[0], row[1]);
                components--;
            }
        }

        return components - 1;
    }

    public static void main(String args[]) {
        int n = 6;
        int connections[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };

        System.out.println(makeConnected(n, connections));
    }
}
