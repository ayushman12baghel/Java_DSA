class Solution {
    int max=0;
    public int longestConsecutive(Node root) {
        solve(root);
        
        return max==1?-1:max;
    }
    
    public int solve(Node root){
        if(root==null){
            return 0;
        }
        
        int left=solve(root.left);
        int right=solve(root.right);
        int ans=1;
        
        if(root.left!=null && root.data+1==root.left.data){
            ans=left+1;
        }
        
        if(root.right!=null && root.data+1==root.right.data){
            ans=Math.max(ans,right+1);
        }
        
        max=Math.max(max,ans);
        
        return ans;
    }
}
