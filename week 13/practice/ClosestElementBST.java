import java.util.*;

public class ClosestElementBST {

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

    static int difference = Integer.MAX_VALUE;
    static int d = -1;

    public static void closestElement(Node root, int k) {
        if (root == null) {
            return;
        }
        int diff = Math.abs(root.data - k);

        if (diff < difference) {
            difference = diff;
            d = diff;
        }
        closestElement(root.left, k);
        closestElement(root.right, k);
    }

    public static void main(String args[]) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right = new Node(11);
        root.right.right = new Node(20);

        closestElement(root, 5);
        System.out.println(d);
    }
}
