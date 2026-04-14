import java.util.*;

//Approach  O(n)
/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int ans = Integer.MIN_VALUE;

    class Info {
        int sum;
        boolean special;

        public Info(int sum, boolean special) {
            this.sum = sum;
            this.special = special;
        }
    }

    int maxPathSum(Node root) {
        Info result = solve(root);
        if (root.left == null || root.right == null) {
            return Math.max(result.sum, ans);
        }

        return ans;
    }

    public Info solve(Node root) {
        if (root == null) {
            return new Info(0, false);
        }

        if (root.left == null && root.right == null) {
            return new Info(root.data, true);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.special && right.special) {
            int sum = left.sum + right.sum + root.data;

            ans = Math.max(ans, sum);

            return new Info(Math.max(left.sum, right.sum) + root.data, true);
        } else if (left.special) {
            return new Info(left.sum + root.data, left.special);
        } else {
            return new Info(right.sum + root.data, right.special);
        }
    }
}