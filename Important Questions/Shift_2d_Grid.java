//Approach O(n*m)
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        int size=n*m;
        k%=size;

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();

            for(int j=0;j<m;j++){
                int currentIndex=i*m+j;
                int oldIndex=(currentIndex-k+size)%size;

                int newValue=grid[oldIndex/m][oldIndex%m];
                temp.add(newValue);
            }

            ans.add(temp);
        }

        return ans;
    }
}
