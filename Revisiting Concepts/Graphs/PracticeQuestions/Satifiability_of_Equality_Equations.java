import java.util.*;

public class Satifiability_of_Equality_Equations {

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

    public static boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                char first = str.charAt(0);
                char second = str.charAt(3);

                dsu.union(first - 'a', second - 'a');
            }
        }

        for (String str : equations) {
            if (str.charAt(1) == '!') {
                if (dsu.find(str.charAt(0) - 'a') == dsu.find(str.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String equations[] = { "b==a", "a==b" };

        System.out.println(equationsPossible(equations));
    }
}
