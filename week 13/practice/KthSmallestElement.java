import java.util.*;

public class KthSmallestElement {

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

    public static void inorder(Node root, int k, int result[]) {
        if (root == null || k <= result[1]) {
            return;
        }

        inorder(root.left, k, result);
        result[1]++;

        if (result[1] == k) {
            result[0] = root.data;
            return;
        }
        inorder(root.right, k, result);
    }

    public static int kthSmallest(Node root, int k) {
        int result[] = new int[2];
        inorder(root, k, result);

        return result[0];
    }

    public static void main(String args[]) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right = new Node(11);
        root.right.right = new Node(20);

        System.out.println(kthSmallest(root, 4));
    }
}
