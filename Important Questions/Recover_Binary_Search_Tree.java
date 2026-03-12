import java.util.*;

//Approach O(n)
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev.val > root.val) {
            if (first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;
        inorder(root.right);
    }
}