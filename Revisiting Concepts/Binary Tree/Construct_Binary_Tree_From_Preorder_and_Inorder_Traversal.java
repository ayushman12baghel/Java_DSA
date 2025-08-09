import java.util.*;

import javax.swing.tree.TreeNode;

public class Construct_Binary_Tree_From_Preorder_and_Inorder_Traversal {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Approach 1 O(n+m)
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, new int[1], 0, inorder.length - 1);
    }

    public static TreeNode solve(int preorder[], int inorder[], int index[], int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        int j = start;
        while (inorder[j] != root.val) {
            j++;
        }

        root.left = solve(preorder, inorder, index, start, j - 1);
        root.right = solve(preorder, inorder, index, j + 1, end);

        return root;
    }

    // Approach 2 More Optimised O(n)
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(preorder, inorder, new int[1], 0, inorder.length - 1, map);
    }

    public static TreeNode solve(int preorder[], int inorder[], int index[], int start, int end,
            HashMap<Integer, Integer> map) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        int j = map.get(root.val);

        root.left = solve(preorder, inorder, index, start, j - 1, map);
        root.right = solve(preorder, inorder, index, j + 1, end, map);

        return root;
    }

    public static void main(String[] args) {
        int preorder[] = { 3, 9, 20, 15, 7 }, inorder[] = { 9, 3, 15, 20, 7 };
    }
}
