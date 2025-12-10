import java.util.*;

//O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = Integer.MAX_VALUE;
        Integer prev[] = new Integer[1];

        inorder(root, prev, ans);

        return ans[0];
    }

    public void inorder(TreeNode root, Integer prev[], int ans[]) {
        if (root == null) {
            return;
        }

        inorder(root.left, prev, ans);
        if (prev[0] != null) {
            ans[0] = Math.min(ans[0], Math.abs(prev[0] - root.val));
        }
        prev[0] = root.val;
        inorder(root.right, prev, ans);

    }
}