import java.util.*;

// Approach 1 Brute Force O(n^2)
class Solution {
    int maxDiff;

    public int maxAncestorDiff(TreeNode root) {
        maxDiff = -1;
        findMaxDiff(root);

        return maxDiff;
    }

    public void findMaxDiff(TreeNode root) {
        if (root == null) {
            return;
        }

        findMaxDiffUtil(root, root.left);
        findMaxDiffUtil(root, root.right);

        findMaxDiff(root.left);
        findMaxDiff(root.right);
    }

    public void findMaxDiffUtil(TreeNode root, TreeNode child) {
        if (root == null || child == null) {
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

        findMaxDiffUtil(root, child.left);
        findMaxDiffUtil(root, child.right);
    }
}

// Approach 2 O(n) Optimised
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return solve(root, root.val, root.val);
    }

    public int solve(TreeNode root, int currentMin, int currentMax) {
        if (root == null) {
            return currentMax - currentMin;
        }

        currentMin = Math.min(currentMin, root.val);
        currentMax = Math.max(currentMax, root.val);

        int left = solve(root.left, currentMin, currentMax);
        int right = solve(root.right, currentMin, currentMax);

        return Math.max(right, left);
    }
}