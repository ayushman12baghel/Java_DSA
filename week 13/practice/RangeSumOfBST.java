import java.util.*;

public class RangeSumOfBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int sum = 0;

    static int rangeSumBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr.data >= low && curr.data <= high) {
                sum += curr.data;
            }

            if (curr.left != null && curr.data > low) {
                q.add(curr.left);
            }
            if (curr.right != null && curr.data < high) {
                q.add(curr.right);
            }
        }

        return sum;

        // if (root.data >= low && root.data <= high) {
        // sum += root.data;
        // }
        // rangeSumBST(root.left, low, high);
        // rangeSumBST(root.right, low, high);
        // return sum;
    }

    public static void main(String args[]) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right = new Node(11);
        root.right.right = new Node(20);

        int L = 5, R = 15;
        System.out.println(rangeSumBST(root, L, R));
    }
}
