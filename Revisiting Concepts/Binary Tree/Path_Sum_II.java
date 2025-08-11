import java.util.*;

public class Path_Sum_II {

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

    // O(n)
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, targetSum, new ArrayList<>(), ans);

        return ans;
    }

    public static void solve(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            ans.add(new ArrayList<>(temp));
        } else {
            solve(root.left, targetSum - root.val, temp, ans);
            solve(root.right, targetSum - root.val, temp, ans);
        }

        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Integer tree[] = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
        int targetSum = 22;
        TreeNode root = buildTree(tree);

        System.out.println(pathSum(root, targetSum));
    }
}
