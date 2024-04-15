class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int solve(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curr;
        }
        int l = solve(root.left, curr);
        int r = solve(root.right, curr);
        return l + r;
    }

    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }
}

public class Sum_root_to_leaf_numbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Solution solution = new Solution();
        int sum = solution.sumNumbers(root);
        System.out.println("Sum of roots: " + sum);
    }
}
