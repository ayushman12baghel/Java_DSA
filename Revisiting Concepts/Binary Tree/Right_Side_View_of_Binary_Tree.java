import java.util.*;
import java.util.LinkedList;

public class Right_Side_View_of_Binary_Tree {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(Integer tree[]) {
        if (tree == null || tree[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
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
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Approach 1 by Level Order Traversal O(n)
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) {
                    ans.add(current.val);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return ans;
    }

    // Approach 2 Using DFS
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        solve(root, 1, ans);

        return ans;
    }

    public static void solve(TreeNode root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (ans.size() < level) {
            ans.add(root.val);
        }

        solve(root.right, level + 1, ans);
        solve(root.left, level + 1, ans);
    }

    public static void main(String args[]) {
        Integer tree[] = { 1, 2, 3, null, 5, null, 4 };
        TreeNode root = buildTree(tree);

        System.out.println(rightSideView(root));
        System.out.println(rightSideView2(root));
    }
}
