/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int ans = -1; // to store median value
    
    public int findMedian(Node root) {
        int nodeCount = countNodes(root);
        
        // If total nodes are even → V(n/2)
        // If total nodes are odd → V((n+1)/2)
        int k = (nodeCount % 2 == 0) ? nodeCount / 2 : (nodeCount + 1) / 2;
        
        getKthElement(root, new int[]{k});
        return ans;
    }
    
    // Function to count total nodes
    public int countNodes(Node root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    // Inorder traversal to find the kth smallest element
    public boolean getKthElement(Node root, int count[]) {
        if (root == null) return false;
        
        // Go left
        if (getKthElement(root.left, count)) return true;
        
        // Visit current node
        count[0]--;
        if (count[0] == 0) {
            ans = root.data;
            return true;
        }
        
        // Go right
        return getKthElement(root.right, count);
    }
}
