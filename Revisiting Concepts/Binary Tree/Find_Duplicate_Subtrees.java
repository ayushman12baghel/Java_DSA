import java.util.*;

// Brute Force with Map O(n^2)
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        getSubtreeString(root, map, ans);

        return ans;
    }

    public String getSubtreeString(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if (root == null) {
            return "N";
        }

        String s = root.val + "," + getSubtreeString(root.left, map, ans) + getSubtreeString(root.right, map, ans);

        if (map.containsKey(s) && map.get(s) == 1) {
            ans.add(root);
        }

        map.put(s, map.getOrDefault(s, 0) + 1);

        return s;
    }
}

// Approach 2 Optimised O(n)
class Solution {
    int id = 1;
    Map<String, Integer> nodeToId = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);

        return ans;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftId = solve(root.left);
        int rightId = solve(root.right);
        String key = root.val + "," + leftId + "," + rightId;
        if (!nodeToId.containsKey(key)) {
            nodeToId.put(key, id++);
        }
        int currId = nodeToId.get(key);
        count.put(currId, count.getOrDefault(currId, 0) + 1);

        if (count.get(currId) == 2) {
            ans.add(root);
        }

        return currId;
    }
}

// More optimised with custom class
class Solution {
    int id = 1;
    Map<Triple, Integer> nodeToId = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);

        return ans;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftId = solve(root.left);
        int rightId = solve(root.right);
        Triple key = new Triple(root.val, leftId, rightId);
        if (!nodeToId.containsKey(key)) {
            nodeToId.put(key, id++);
        }
        int currId = nodeToId.get(key);
        count.put(currId, count.getOrDefault(currId, 0) + 1);

        if (count.get(currId) == 2) {
            ans.add(root);
        }

        return currId;
    }

    static class Triple {
        int val;
        int left;
        int right;

        public Triple(int val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof Triple)) {
                return false;
            }

            Triple t = (Triple) o;
            return this.val == t.val && this.left == t.left && this.right == t.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}