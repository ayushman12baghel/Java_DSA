import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class Reverse_Odd_Levels_of_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

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

    public static TreeNode buildTree(int values[], int index) {
        if (index >= values.length) {
            return null;
        }

        TreeNode root = new TreeNode(values[index]);
        root.left = buildTree(values, 2 * index + 1);
        root.right = buildTree(values, 2 * index + 2);

        return root;
    }

    // By BFS
    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                current.add(temp);

                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            if (level % 2 != 0) {
                int left = 0;
                int right = current.size() - 1;
                while (left < right) {
                    int temp = current.get(left).val;
                    current.get(left).val = current.get(right).val;
                    current.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }

        return root;
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    // By DFS

    public static TreeNode reverseOddLevels2(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    public static void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null) {
            return;
        }
        if (right == null) {
            return;
        }

        if (level % 2 != 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }

    public static void main(String args[]) {
        int values[] = { 2, 3, 5, 8, 13, 21, 34 };
        TreeNode root = buildTree(values, 0);
        levelOrder(root);
        System.out.println();
        TreeNode ans = reverseOddLevels(root);
        levelOrder(ans);
        System.out.println();
        TreeNode ans2 = reverseOddLevels2(root);
        levelOrder(ans2);
    }
}
