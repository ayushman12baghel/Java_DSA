import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class Lowest_Common_Ancestor_of_Deepest_Leaves {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(Integer tree[]) {
        if (tree[0] == null || tree.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < tree.length) {
            TreeNode current = queue.poll();

            if (i < tree.length && tree[i] != null) {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < tree.length && tree[i] != null) {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Approach 1
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        int height = height(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            height--;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    if (height == 1) {
                        list.add(current.left);
                    }
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    if (height == 1) {
                        list.add(current.right);
                    }
                    queue.offer(current.right);
                }
            }
        }

        if (list.size() == 0) {
            return root;
        }

        TreeNode result = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            result = lca(root, result, list.get(i));
        }

        return result;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String args[]) {
        Integer tree[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = buildTree(tree);

        System.out.println(lcaDeepestLeaves(root).value);
    }
}
