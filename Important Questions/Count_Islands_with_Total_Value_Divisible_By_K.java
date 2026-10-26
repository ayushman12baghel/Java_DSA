//Approach 1 Using BFS O(n*m)
class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        boolean visited[][]=new boolean[n][m];
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    count+=bfs(grid,i,j,visited,k);
                }
            }
        }

        return count;
    }

    int directions[][]={{1,0},{0,1},{-1,0},{0,-1}};

    public int bfs(int grid[][],int i,int j,boolean visited[][],int k){
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        long sum=grid[i][j];
        visited[i][j]=true;

        while(!queue.isEmpty()){
            int current[]=queue.poll();
            int row=current[0];
            int col=current[1];

            for(int direction[]:directions){
                int newRow=direction[0]+row;
                int newCol=direction[1]+col;

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]!=0 && !visited[newRow][newCol]){
                    visited[newRow][newCol]=true;
                    sum+=grid[newRow][newCol];
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }

        return sum%k==0?1:0;
    }
}

//Approach 2 Modifying Input Grid eliminating the need for Visited Array O(n*m)
class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    count+=bfs(grid,i,j,k);
                }
            }
        }

        return count;
    }

    int directions[][]={{1,0},{0,1},{-1,0},{0,-1}};

    public int bfs(int grid[][],int i,int j,int k){
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        long sum=grid[i][j];
        grid[i][j]=0;

        while(!queue.isEmpty()){
            int current[]=queue.poll();
            int row=current[0];
            int col=current[1];

            for(int direction[]:directions){
                int newRow=direction[0]+row;
                int newCol=direction[1]+col;

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]!=0){
                    sum+=grid[newRow][newCol];
                    grid[newRow][newCol]=0;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }

        return sum%k==0?1:0;
    }
}
