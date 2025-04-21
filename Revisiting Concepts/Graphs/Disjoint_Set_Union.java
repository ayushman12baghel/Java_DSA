//Not Optimised O(n)
class DSU1 {
    int parent[];

    public DSU1(int n) {
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
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }
}

// Using Path Compression and Rank
class DSU2 {
    int parent[];
    int rank[];

    public DSU2(int n){
        this.parent=new int[n];
        this.rank[]=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
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
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
}

// DSU by Size
class DSU3 {
    int parent[];
    int size[];

    public DSU3(int n) {
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