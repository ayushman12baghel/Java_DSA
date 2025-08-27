import java.util.*;

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);

        return maxSum;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int onlyRoot = root.val;
        int chooseOne = Math.max(left, right) + root.val;
        int all = left + right + root.val;
        maxSum = Math.max(maxSum, Math.max(onlyRoot, Math.max(chooseOne, all)));

        return Math.max(onlyRoot, chooseOne);
    }
}