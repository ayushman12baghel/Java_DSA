class Solution {
    class Info{
        int height;
        int parent;
        
        public Info(int height,int parent){
            this.height=height;
            this.parent=parent;
        }
    }
    
    public boolean areCousins(Node root, int a, int b) {
        // code here
        if(root==null){
            return true;
        }
        
        Info findA=solve(root,a,0,-1);
        Info findB=solve(root,b,0,-1);
        if(findA==null || findB==null){
            return false;
        }
        
        if(findA.height!=findB.height || findA.parent==findB.parent){
            return false;
        }
        
        return true;
    }
    
    public Info solve(Node root,int target,int depth,int parent){
        if(root==null){
            return null;
        }
        
        if(target==root.data){
            return new Info(depth,parent);
        }
        
        Info left=solve(root.left,target,depth+1,root.data);
        if(left!=null){
            return left;
        }
        
        return solve(root.right,target,depth+1,root.data);
    }
}
