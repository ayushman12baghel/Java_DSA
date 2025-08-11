import java.util.*;

public class Delete_Nodes_and_Return_Forest {

    // PostOrder Traversal
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }

        solve(root, set, ans);

        if (!set.contains(root.val)) {
            ans.add(root);
        }

        return ans;
    }

    public TreeNode solve(TreeNode root, Set<Integer> set, List<TreeNode> ans) {
        if (root == null) {
            return root;
        }

        root.left = solve(root.left, set, ans);
        root.right = solve(root.right, set, ans);

        if (set.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }

            return null;
        }

        return root;
    }
}
