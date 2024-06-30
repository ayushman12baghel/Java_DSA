import java.util.*;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class Binary_Tree_Paths {

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

    static class BinaryTree {
        Node root;

        public Node insertLevelOrder(Integer arr[], Node root, int i) {

            if (i < arr.length) {
                Node temp = null;

                if (arr[i] != null) {
                    temp = new Node(arr[i]);
                    root = temp;

                    root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
                    root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
                }
            }
            return root;
        }

        public Node buildTree(Integer arr[]) {
            return insertLevelOrder(arr, root, 0);
        }
    }

    public static List<String> binaryTreePaths(Node root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    public static void dfs(Node root, String path, List<String> result) {
        if (root == null) {
            return;
        }

        path += root.data;

        if (root.left == null && root.right == null) {
            result.add(path);
        } else {
            path += "->";
            dfs(root.left, path, result);
            dfs(root.right, path, result);
        }
    }

    public static List<String> binaryTreePaths2(Node root) {
        List<String> result = new ArrayList<>();
        dfs2(root, new StringBuilder(), result);
        return result;
    }

    public static void dfs2(Node root, StringBuilder path, List<String> result) {
        if (root == null) {
            return;
        }

        int len = path.length();
        if (len > 0) {
            path.append("->");
        }
        path.append(root.data);

        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            dfs2(root.left, path, result);
            dfs2(root.right, path, result);
        }
        path.setLength(len);
    }

    public static void main(String args[]) {
        Integer arr[] = { 1, 2, 3, null, 5 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
        List<String> list = binaryTreePaths(root);
        List<String> list2 = binaryTreePaths2(root);

        System.out.println(list);
        System.out.println(list2);
    }
}
