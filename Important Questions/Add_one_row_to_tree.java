class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }
}

class Solution {
    public TreeNode add(TreeNode root, int val, int depth, int curr) {
        if (root == null) {
            return null;
        }
        if (curr == depth - 1) {
            TreeNode leftTemp = root.left;
            TreeNode rightTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = leftTemp;
            root.right.right = rightTemp;

            return root;
        }
        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);
        return root;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            newRoot.right = null;
            return newRoot;
        }
        int curr = 1;
        return add(root, val, depth, curr);
    }
}

public class Add_one_row_to_tree {
    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = null;
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        Solution solution = new Solution();
        TreeNode newRoot = solution.addOneRow(root, 1, 3);
        printTree(newRoot);
    }
}
