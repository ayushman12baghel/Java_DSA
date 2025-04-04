import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Lowest_Common_Ancestor_of_Binary_Tree {

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

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.value == val)
            return root;

        TreeNode left = findNode(root.left, val);
        if (left != null)
            return left;

        return findNode(root.right, val);
    }

    // Approach 1 By storing path
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        getLCA(root, list1, p);
        getLCA(root, list2, q);

        int i = 0;
        for (; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                break;
            }
        }

        return list1.get(i - 1);
    }

    public static boolean getLCA(TreeNode root, ArrayList<TreeNode> list, TreeNode n) {
        if (root == null) {
            return false;
        }

        list.add(root);
        if (root == n) {
            return true;
        }

        boolean left = getLCA(root.left, list, n);
        boolean right = getLCA(root.right, list, n);

        if (left || right) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;
    }

    // Approach 2
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String args[]) {
        Integer tree[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = buildTree(tree);
        TreeNode p = findNode(root, 5);
        TreeNode q = findNode(root, 4);

        System.out.println(lowestCommonAncestor(root, p, q).value);
        System.out.println(lowestCommonAncestor2(root, p, q).value);
    }
}
