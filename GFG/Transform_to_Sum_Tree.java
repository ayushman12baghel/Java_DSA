import java.util.*;

class Solution {
    public void toSumTree(Node root) {
        // code here
        solve(root);
        return;
    }

    public int solve(Node root) {
        if (root == null) {
            return 0;
        }

        int value = root.data;
        int left = solve(root.left);
        int right = solve(root.right);

        root.data = left + right;

        return value + left + right;
    }
}