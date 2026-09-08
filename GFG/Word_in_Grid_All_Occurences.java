//Approach O(n*m*word.length)
class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] grid, String word) {
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        int directions[][]={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==word.charAt(0)){
                    boolean found=false;
                    for(int direction[]:directions){
                        int r=i;
                        int c=j;
                        int k;
                        
                        for(k=1;k<word.length();k++){
                            r+=direction[0];
                            c+=direction[1];
                            
                            if(r<0 || r>=n || c<0 || c>=m || grid[r][c]!=word.charAt(k)){
                                break;
                            }
                        }
                        
                        if(k==word.length()){
                            found=true;
                            break;
                        }
                    }
                    
                    if(found){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        ans.add(temp);
                    }
                }
            }
        }
        
        return ans;
    }
};
