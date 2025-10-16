import java.util.*;

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        return solve(root, l, r);
    }

    public Node solve(Node root, int l, int r) {
        if (root == null) {
            return null;
        }

        root.left = solve(root.left, l, r);
        root.right = solve(root.right, l, r);

        if (root.data < l) {
            return root.right;
        }

        if (root.data > r) {
            return root.left;
        }

        return root;
    }
}