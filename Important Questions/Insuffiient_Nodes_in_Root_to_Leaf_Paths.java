import java.util.*;

// Approach O(n)
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root.val >= limit ? root : null;
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        if (root.left == null && root.right == null) {
            return null;
        }

        return root;
    }
}