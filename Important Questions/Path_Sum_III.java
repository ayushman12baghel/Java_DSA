import java.util.*;

//Approach 1 O(n^2)
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + solve(root, targetSum, 0);
    }

    public int solve(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        sum += root.val;
        if (targetSum == sum) {
            count++;
        }

        count += solve(root.left, targetSum, sum);
        count += solve(root.right, targetSum, sum);

        return count;
    }
}

// Approach 2 Prefix Sum Using Hashmap O(n)
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return solve(root, targetSum, 0, map);
    }

    public int solve(TreeNode root, int targetSum, long sum, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        sum += root.val;

        if (map.containsKey(sum - targetSum)) {
            count += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += solve(root.left, targetSum, sum, map);
        count += solve(root.right, targetSum, sum, map);

        map.put(sum, map.get(sum) - 1);

        return count;
    }
}