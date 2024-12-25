import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class find_Largest_Value_In_Tree_Row {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildTree(Integer values[], int index) {
        if (index >= values.length || values[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[index]);
        root.left = buildTree(values, 2 * index + 1);
        root.right = buildTree(values, 2 * index + 2);
        return root;
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                max = Math.max(max, current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            list.add(max);
        }

        return list;
    }

    public static void main(String args[]) {
        Integer values[] = { 1, 3, 2, 5, 3, null, 9 };
        TreeNode root = buildTree(values, 0);

        List<Integer> list = largestValues(root);
        System.out.println(list);
    }
}
