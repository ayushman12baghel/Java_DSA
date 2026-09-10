//Approach O(n)
class Solution {
    class Info{
        int sum;
        int nodes;

        public Info(int sum,int nodes){
            this.sum=sum;
            this.nodes=nodes;
        }
    }

    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);

        return ans;
    }

    public Info solve(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }

        Info left=solve(root.left);
        Info right=solve(root.right);

        int sum=left.sum+right.sum+root.val;
        int nodes=left.nodes+right.nodes+1;

        if(sum/nodes==root.val){
            ans++;
        }

        return new Info(sum,nodes);
    }
}
