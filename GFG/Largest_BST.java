import java.util.*;

// Approach Using Tree DP and Property of BST O(n)

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    static class Info {
        boolean isBST;
        int min;
        int max;
        int nodes;

        public Info(boolean isBST, int min, int max, int nodes) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.nodes = nodes;
        }
    }

    static int ans;

    static int largestBst(Node root) {
        ans = 0;
        solve(root);

        return ans;
    }

    public static Info solve(Node root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST && left.max < root.data && root.data < right.min) {
            int nodes = left.nodes + right.nodes + 1;
            int min = Math.min(left.min, root.data);
            int max = Math.max(right.max, root.data);
            ans = Math.max(ans, nodes);

            return new Info(true, min, max, nodes);
        }

        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    }
}