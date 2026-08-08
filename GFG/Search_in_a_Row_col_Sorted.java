//Approach O(n)
class Solution {
    public static boolean matSearch(int grid[][], int x) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        
        int row=0;
        int col=m-1;
        
        while(row<n && col>=0){
            if(grid[row][col]==x){
                return true;
            }
            if(grid[row][col]<x){
                row++;
            }else if(grid[row][col]>x){
                col--;
            }
            
        }
        
        return false;
    }
}
