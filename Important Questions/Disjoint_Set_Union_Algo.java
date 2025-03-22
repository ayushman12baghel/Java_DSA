//Not optimised
class DSU {
    int n;
    int parent[];

    public DSU(int n) {
        this.n = n;
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (i == parent[i]) {
            return i;
        }

        return find(parent[i]);
    }

    public void union(int x, int y) {
        int parent_X = find(x);
        int parent_Y = find(y);

        if (parent_X != parent_Y) {
            parent[parent_X] = parent_Y;
        }
    }
}

// Optimised Using Path Compression and Rank Array
class DSU2 {
    int n;
    int parent[];
    int rank[];

    public DSU2(int n) {
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < parent.length; i++) {
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

        if (rank[parentX] > parentY) {
            parent[parentY] = parentX;
        } else if (parentX < parentY) {
            parent[parentX] = parentY;
        } else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
}

// DSU Using Size
class DSU3 {
    int n;
    int parent[];
    int size[];

    public DSU3(int n) {
        this.n = n;
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
        } else if (size[parentX] < size[parentY]) {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
    }
}

public class Disjoint_Set_Union_Algo {
    public static void main(String args[]) {
        DSU dsu = new DSU(5);

        dsu.union(0, 1);
        dsu.union(1, 2);

        System.out.println(dsu.find(0));
        System.out.println(dsu.find(2));

        DSU2 dsu2 = new DSU2(5);

        dsu2.union(0, 1);
        dsu.union(1, 2);

        System.out.println(dsu2.find(0));
        System.out.println(dsu2.find(2));
        DSU3 dsu3 = new DSU3(5);
        dsu3.union(0, 1);
        dsu3.union(1, 2);

        System.out.println(dsu3.find(0));
        System.out.println(dsu3.find(2));
    }
}
