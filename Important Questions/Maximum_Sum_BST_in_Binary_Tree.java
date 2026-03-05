import java.util.*;

// Brute Force Approach O(n^2)
class Solution {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        solve(root);

        return maxSum;
    }

    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }

        if (validateTree(root, null, null)) {
            maxSum = Math.max(maxSum, getSum(root));
        }

        solve(root.left);
        solve(root.right);
    }

    public boolean validateTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (max != null && max.val <= root.val) {
            return false;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        return validateTree(root.left, min, root) && validateTree(root.right, root, max);
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }
}

// Approach 2 Storing Everything I need per Node O(n) TIme + O(n) Space
class Solution {
    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        public Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        solve(root);

        return maxSum;
    }

    public Info solve(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int sum = root.val + left.sum + right.sum;
            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);

            maxSum = Math.max(maxSum, sum);

            return new Info(true, min, max, sum);
        }

        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}