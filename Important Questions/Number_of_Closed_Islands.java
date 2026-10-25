//Approach 1 Using bfs O(n*m)
class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean visited[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            if(!visited[i][0] && grid[i][0]==0){
                bfs(grid,i,0,visited);
            }

            if(!visited[i][m-1] && grid[i][m-1]==0){
                bfs(grid,i,m-1,visited);
            }
        }

        for(int j=0;j<m;j++){
            if(!visited[0][j] && grid[0][j]==0){
                bfs(grid,0,j,visited);
            }

            if(!visited[n-1][j] && grid[n-1][j]==0){
                bfs(grid,n-1,j,visited);
            }
        }

        int ans=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visited[i][j]){
                    if(grid[i][j]==0){
                        ans++;
                    }

                    bfs(grid,i,j,visited);
                }
            }
        }

        return ans;
    }

    static int directions[][]={{1,0},{0,1},{-1,0},{0,-1}};

    public void bfs(int grid[][],int i,int j,boolean visited[][]){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j]=true;
        int value=grid[i][j];

        while(!queue.isEmpty()){
            int current[]=queue.poll();
            int row=current[0];
            int col=current[1];

            for(int direction[]:directions){
                int newRow=direction[0]+row;
                int newCol=direction[1]+col;

                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && !visited[newRow][newCol] && grid[newRow][newCol]==value){
                    queue.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;
                }
            }
        }
    }
}

//Approach 2 Using DSU O(n*m)
class Solution {
    class DSU{
        int parent[];
        int size[];

        public DSU(int n){
            parent=new int[n];
            size=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int find(int i){
            if(i==parent[i]){
                return i;
            }

            return parent[i]=find(parent[i]);
        }

        public void union(int x,int y){
            int parentX=find(x);
            int parentY=find(y);

            if(parentX==parentY){
                return;
            }

            if(size[parentX]>size[parentY]){
                size[parentX]+=size[parentY];
                parent[parentY]=parentX;
            }else{
                size[parentY]+=size[parentX];
                parent[parentX]=parentY;
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int size=n*m;
        DSU dsu=new DSU(size+2);
        int dummy=size+1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int id=i*m+j;

                    if(i==0 || j==0 || i==n-1 || j==m-1){
                        dsu.union(dummy,id);
                    }

                    if(i+1<n && grid[i+1][j]==0){
                        dsu.union(id,(i+1)*m+j);
                    }

                    if(j+1<m && grid[i][j+1]==0){
                        dsu.union(id,i*m+j+1);
                    }
                }
            }
        }

        int count=0;
        int dummyRoot=dsu.find(dummy);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int id=i*m+j;

                    if(id==dsu.find(id) && dsu.find(id)!=dummyRoot){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
