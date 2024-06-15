import java.util.ArrayList;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class Validate_BST {

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

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void inorder2(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder2(root.left, list);
        list.add(root.data);
        inorder2(root.right, list);

    }

    public static boolean validate(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBST2(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder2(root, list);
        return validate(list);
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        if (isValidBST(root, null, null)) {
            System.out.println("Valid");
        } else {
            System.out.println("not Valid.0");
        }
        if (isValidBST2(root)) {
            System.out.println("Valid");
        } else {
            System.out.println("not Valid.0");
        }
    }
}
