import java.util.*;

class Solution {
    long result = 0;
    int mod = 1000000007;

    public int maxProduct(TreeNode root) {
        long totalSum = findSum(root);
        solve(root, totalSum);

        return (int) (result % mod);
    }

    public long findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + findSum(root.left) + findSum(root.right);
    }

    public long solve(TreeNode root, long totalSum) {
        if (root == null) {
            return 0;
        }

        long left = solve(root.left, totalSum);
        long right = solve(root.right, totalSum);

        long subtreeSum = root.val + left + right;
        result = Math.max(result, (totalSum - subtreeSum) * subtreeSum);

        return subtreeSum;
    }
}