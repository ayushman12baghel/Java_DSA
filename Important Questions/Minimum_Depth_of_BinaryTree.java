import java.util.*;
import java.util.LinkedList;

public class Minimum_Depth_of_BinaryTree {
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

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = minDepth(root.left);
        int rh = minDepth(root.right);

        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return rh + 1;
        }
        if (root.right == null) {
            return lh + 1;
        }

        return Math.min(lh, rh) + 1;
    }

    public static int minDepth2(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node temp = q.remove();

                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            depth++;
        }

        return depth;

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
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        System.out.println(minDepth(root));

        System.out.println(minDepth2(root));
    }
}
