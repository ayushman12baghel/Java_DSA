import java.util.*;
import java.util.LinkedList;

public class Has_Path_Sum {

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

    public static void prinLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                System.out.println();
                if (q.isEmpty()) {
                    return;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static boolean hasPathSum(Node root, int targerSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targerSum == root.data;
        }

        boolean left = hasPathSum(root.left, targerSum - root.data);
        boolean right = hasPathSum(root.right, targerSum - root.data);

        return left || right;
    }

    public static void main(String args[]) {
        Integer[] arr = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
        prinLevelOrder(root);
        int targetSum = 22;

        System.out.println(hasPathSum(root, targetSum));
    }
}
