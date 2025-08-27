import java.util.*;

// O(n)
class Solution {
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    public int solve(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        current = (current * 10 + root.val);
        if (root.left == null && root.right == null) {
            return current;
        }

        int left = solve(root.left, current);
        int right = solve(root.right, current);

        return left + right;
    }
}