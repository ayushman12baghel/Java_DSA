//Approach Using Multi Source BFS O(n*m)
class Solution {
    int shortestPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        
        boolean unsafe[][]=new boolean[n][m];
        int directions[][]={{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    unsafe[i][j]=true;
                    
                    for(int direction[]:directions){
                        int row=direction[0]+i;
                        int col=direction[1]+j;
                        
                        if(row>=0 && row<n && col>=0 && col<m){
                            unsafe[row][col]=true;
                        }
                    }
                }
            }
        }
        
        Queue<int[]> queue=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            if(!unsafe[i][0]){
                queue.offer(new int[]{i,0,1});
                visited[i][0]=true;
            }
        }
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                int current[]=queue.poll();
                int row=current[0];
                int col=current[1];
                int cost=current[2];
                
                if(col==m-1){
                    return cost;
                }
                
                for(int direction[]:directions){
                    int newRow=row+direction[0];
                    int newCol=col+direction[1];
                    
                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !visited[newRow][newCol]
                        && !unsafe[newRow][newCol]){
                            queue.offer(new int[]{newRow,newCol,cost+1});
                            visited[newRow][newCol]=true;
                        }
                }
            }
        }
        
        return -1;
    }
}
