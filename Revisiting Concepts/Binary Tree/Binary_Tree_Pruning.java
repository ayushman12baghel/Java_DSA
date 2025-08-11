import java.util.*;
import java.util.LinkedList;

public class Binary_Tree_Pruning {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(Integer tree[]) {
        if (tree.length == 0 || tree[0] == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(tree[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < tree.length) {
            TreeNode current = queue.poll();

            if (i < tree.length && tree[i] != null) {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < tree.length && tree[i] != null) {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
        }
    }

    // Approach 1 Brute Force O(n^2)
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        pruneTree(root.left);
        pruneTree(root.right);

        if (!checkOne(root.left)) {
            root.left = null;
        }

        if (!checkOne(root.right)) {
            root.right = null;
        }

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    public static boolean checkOne(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.val == 1) {
            return true;
        }

        return checkOne(root.left) || checkOne(root.right);
    }

    // Approach 2 O(n)
    public static TreeNode pruneTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer tree[] = { 1, 0, 1, 0, 0, 0, 1 };
        TreeNode root = buildTree(tree);
        printTree(root);
        printTree(pruneTree(root));
        printTree(pruneTree2(root));
    }
}
