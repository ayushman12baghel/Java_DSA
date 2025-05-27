import java.util.*;

public class House_Robber_III {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Aprroach 1 Using Recursion T.L.E
    public static int rob(TreeNode root) {
        int ans1 = solve(root, true);
        int ans2 = solve(root, false);
        return Math.max(ans1, ans2);
    }

    public static int solve(TreeNode root, boolean canTake) {
        if (root == null) {
            return 0;
        }

        if (canTake) {
            int rob = root.val + solve(root.left, false) + solve(root.right, false);
            int skip = solve(root.left, true) + solve(root.right, true);
            return Math.max(rob, skip);
        } else {
            return solve(root.left, true) + solve(root.right, true);
        }
    }

    // Approach 2 -> Using Memoisation HashMap O(n)
    public static int rob2(TreeNode root) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        int ans1 = solve(root, false, map1);
        int ans2 = solve(root, true, map2);

        return Math.max(ans1, ans2);
    }

    public static int solve(TreeNode root, boolean canTake, Map<String, Integer> map) {
        if (root == null) {
            return 0;
        }

        String key = root + "-" + canTake;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result;
        if (canTake) {
            int rob = root.val + solve(root.left, false, map) + solve(root.right, false, map);
            int skip = solve(root.left, true, map) + solve(root.right, true, map);
            result = Math.max(rob, skip);
        } else {
            result = solve(root.left, true, map) + solve(root.right, true, map);
        }

        map.put(key, result);

        return result;
    }

    // Approach 3 Optimised
    public static int rob3(TreeNode root) {
        int ans[] = solve(root);

        return Math.max(ans[0], ans[1]);
    }

    public static int[] solve(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int left[] = solve(root.left);
        int right[] = solve(root.right);

        int rob = root.val + left[1] + right[1];
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { rob, skip };
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));
        System.out.println(rob2(root));
        System.out.println(rob3(root));
    }
}
