import java.util.*;

//Approach Using Dynamic Programming O(n)
class Solution {
    // 0 -> has Camera, 1 -> is Covered, 2-> not covered
    Map<TreeNode, Integer[]> map = new HashMap<>();

    public int minCameraCover(TreeNode root) {
        return solve(root, 1);
    }

    public int solve(TreeNode root, int state) {
        if (root == null) {
            if (state == 2) {
                return 10000;
            }

            return 0;
        }

        if (map.containsKey(root) && map.get(root)[state] != null) {
            return map.get(root)[state];
        }

        if (!map.containsKey(root)) {
            map.put(root, new Integer[3]);
        }

        int ans = 10000;

        if (state == 0) {
            int skip = solve(root.left, 1) + solve(root.right, 1);
            int placed = 1 + solve(root.left, 0) + solve(root.right, 0);

            ans = Math.min(skip, placed);
        } else if (state == 1) {
            int place = 1 + solve(root.left, 0) + solve(root.right, 0);

            int forceLeft = solve(root.left, 2) + solve(root.right, 1);
            int forceRight = solve(root.left, 1) + solve(root.right, 2);

            ans = Math.min(place, Math.min(forceLeft, forceRight));
        } else {
            ans = 1 + solve(root.left, 0) + solve(root.right, 0);
        }

        map.get(root)[state] = ans;

        return ans;
    }
}

// Approach 2 Bottom Up Dp
class Solution {
    public int minCameraCover(TreeNode root) {
        int ans[] = solve(root);

        return Math.min(ans[0], ans[1]);
    }

    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[] { 10000, 0, 0 };
        }

        int left[] = solve(root.left);
        int right[] = solve(root.right);
        int dp[] = new int[3];

        int minL = Math.min(left[0], Math.min(left[1], left[2]));
        int minR = Math.min(right[0], Math.min(right[1], right[2]));

        // Has Camera
        dp[0] = 1 + minL + minR;

        // Is Covered
        dp[1] = Math.min(left[0] + right[0], Math.min(left[0] + right[1], left[1] + right[0]));

        // Has not Covered and nor has a camera
        dp[2] = left[1] + right[1];

        return dp;
    }
}