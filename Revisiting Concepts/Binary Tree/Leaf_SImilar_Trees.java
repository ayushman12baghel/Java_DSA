import java.util.*;

//Approach T.C -> O(n+m)
// Space = O(L1+L2)
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = getLeaves(root1);
        List<Integer> leaf2 = getLeaves(root2);

        if (leaf1.size() != leaf2.size()) {
            return false;
        }

        for (int i = 0; i < leaf1.size(); i++) {
            if (leaf1.get(i).intValue() != leaf2.get(i).intValue()) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> getLeaves(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        fillLeaves(root, ans);

        return ans;
    }

    public void fillLeaves(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }

        fillLeaves(root.left, ans);
        fillLeaves(root.right, ans);
    }
}