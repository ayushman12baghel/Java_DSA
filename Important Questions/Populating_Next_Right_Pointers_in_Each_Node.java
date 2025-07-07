import java.util.*;

class Node {
    Node left;
    Node right;
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}