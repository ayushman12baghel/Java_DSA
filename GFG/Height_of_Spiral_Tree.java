//Approach O(n)
class Solution {
    public int findTreeHeight(Node root) {
        // code here
        if(root==null){
            return 0;
        }
        
        if(isLeaf(root)){
            return 0;
        }
        
        return 1+Math.max(findTreeHeight(root.left),findTreeHeight(root.right));
    }
    
    
    public boolean isLeaf(Node node){
        return node.left!=null && node.right!=null && node.left.right==node && node.right.left==node;
    }
}
