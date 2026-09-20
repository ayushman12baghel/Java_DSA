//Approach 1 Brute Force O(n^4)
class Solution {
    public int largestSubsquare(char grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int size=Math.min(n-i,m-j);
                
                for(int L=size;L>ans;L--){
                    if(isValid(grid,i,j,L)){
                        ans=L;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean isValid(char grid[][],int row,int col,int L){
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=row;i<row+L;i++){
            if(grid[i][col]=='O' || grid[i][col+L-1]=='O'){
                return false;
            }
        }
        
        for(int j=col;j<col+L;j++){
            if(grid[row][j]=='O' || grid[row+L-1][j]=='O'){
                return false;
            }
        }
        
        return true;
    }
};

//Approach 2 Optimal O(n^3)
class Solution {
    public int largestSubsquare(char grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
        
        int top[][]=new int[n][m];
        int left[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    left[i][j]=(j==0?1:left[i][j-1]+1);
                    top[i][j]=(i==0?1:top[i-1][j]+1);
                }
            }
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int size=Math.min(n-i,m-j);
                
                for(int L=size;L>ans;L--){
                    if(left[i][j+L-1]>=L && left[i+L-1][j+L-1]>=L &&
                        top[i+L-1][j]>=L && top[i+L-1][j+L-1]>=L){
                        ans=L;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
};
