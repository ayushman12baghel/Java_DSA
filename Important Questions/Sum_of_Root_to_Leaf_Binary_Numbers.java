import java.util.*;

class Solution {

    int solve(TreeNode root, int val) {

        if (root == null) {
            return 0;
        }

        val = (2 * val) + root.val;

        // If leaf node
        if (root.left == null && root.right == null) {
            return val;
        }

        return solve(root.left, val) + solve(root.right, val);
    }

    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }
}