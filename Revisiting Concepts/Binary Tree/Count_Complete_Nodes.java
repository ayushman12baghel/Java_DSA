import java.util.*;

//Basic Approach O(n)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// Required Optimised Approach O(logn*logn)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int leftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + leftHeight(root.left);
    }

    public int rightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + rightHeight(root.right);
    }
}