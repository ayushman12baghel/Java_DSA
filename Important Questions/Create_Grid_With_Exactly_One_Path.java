// Approach O(n*m) and O(m) space 
class Solution {
    public String[] createGrid(int n, int m) {
        String ans[]=new String[n];
        StringBuilder temp=new StringBuilder();
        int x=0;
        for(int i=0;i<m;i++){
            temp.append('.');
        }
        ans[x++]=temp.toString();
        
        for(int i=1;i<n;i++){
            temp=new StringBuilder();
            for(int j=0;j<m-1;j++){
                temp.append('#');
            }

            temp.append('.');
            ans[x++]=temp.toString();
        }

        return ans;
    }
}
