import java.util.*;

//Approach Using BFS O(n) time and O(n) space
class Solution {
    boolean check(Node root) {
        if(root==null){
            return true;
        }
        
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        boolean seenLeaf=false;
        int seenLeafLevel=-1;
        int level=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                Node current=queue.poll();
                
                if(current.left==null && current.right==null){
                    if(seenLeaf && seenLeafLevel!=level){
                        return false;
                    }
                    seenLeaf=true;
                    seenLeafLevel=level;
                }
                
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            
            level++;c
        }
        
        return true;
    }
}

// Approach 2 DFS O(n) time and O(h) space
class Solution {
    int leafLevel = -1;

    boolean check(Node root) {
        return dfs(root, 0);
    }

    boolean dfs(Node root, int level) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (leafLevel == -1) {
                leafLevel = level;
                return true;
            }

            return level == leafLevel;
        }

        return dfs(root.left, level + 1) && dfs(root.right, level + 1);
    }
}