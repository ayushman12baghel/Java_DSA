import java.util.*;

public class TreeUnivalued {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean checkUnivalued(Node root, int data) {
        if (root == null) {
            return true;
        }
        if (root.data != data) {
            return false;
        }
        checkUnivalued(root.left, data);
        checkUnivalued(root.right, data);
        return true;
    }

    public static void main(String args[]) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

        System.out.println(checkUnivalued(root, root.data));
    }
}