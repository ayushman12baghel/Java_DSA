import java.util.*;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;

            return newRoot;
        }

        return addRow(root, val, depth, 1);
    }

    public TreeNode addRow(TreeNode root, int val, int depth, int currentDepth) {
        if (root == null) {
            return null;
        }

        if (currentDepth == depth - 1) {
            TreeNode leftTemp = root.left;
            TreeNode rightTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = leftTemp;
            root.right.right = rightTemp;

            return root;
        }

        root.left = addRow(root.left, val, depth, currentDepth + 1);
        root.right = addRow(root.right, val, depth, currentDepth + 1);

        return root;
    }
}