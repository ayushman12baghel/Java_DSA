import java.util.*;

public class Find_Leaves_of_Binary_Tree {
    // Problem Statement
    /**
     * Given the root of a binary tree, collect its nodes as if you were doing this:
     * 
     * Collect all the leaf nodes.
     * 
     * Remove all the leaf nodes.
     * 
     * Repeat the process until the tree is empty.
     * 
     * Return a list of lists of integers, where each sublist contains the values of
     * the leaves collected in each removal pass.
     * 
     * 
     * __1
     * /__ \
     * 2 ____ 3
     * / \
     * 4 5
     */

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Approach Collecting All Nodes with same height
    public static List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        collectNodesWithSameHeight(root, map);

        return new ArrayList<>(map.values());
    }

    public static int collectNodesWithSameHeight(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return 0;
        }

        int height = 1
                + Math.max(collectNodesWithSameHeight(root.left, map), collectNodesWithSameHeight(root.right, map));

        map.computeIfAbsent(height, k -> new ArrayList<>()).add(root.val);

        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(findLeaves(root));
    }

}
