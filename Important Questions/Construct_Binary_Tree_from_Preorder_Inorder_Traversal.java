import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Construct_Binary_Tree_from_Preorder_Inorder_Traversal {

    // Approach 1 Brute Force O(n^2)
    public static TreeNode buildTree(int preorder[], int inorder[]) {
        return solve(new int[1], 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode solve(int preIndex[], int inStart, int inEnd, int preorder[], int inorder[]) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex[0]]);

        int j = inStart;
        while (inorder[j] != root.val) {
            j++;
        }

        preIndex[0]++;

        root.left = solve(preIndex, inStart, j - 1, preorder, inorder);
        root.right = solve(preIndex, j + 1, inEnd, preorder, inorder);

        return root;
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            System.out.println();
        }
    }

    // Approach 2 Using HashMap O(n);
    public static TreeNode buildTree2(int preorder[], int inorder[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return solve(new int[1], 0, inorder.length - 1, preorder, inorder, map);
    }

    public static TreeNode solve(int preIndex[], int inStart, int inEnd, int preorder[], int inorder[],
            HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex[0]]);

        int j = map.get(root.val);

        preIndex[0]++;

        root.left = solve(preIndex, inStart, j - 1, preorder, inorder, map);
        root.right = solve(preIndex, j + 1, inEnd, preorder, inorder, map);

        return root;
    }

    public static void main(String args[]) {
        int inorder[] = { 9, 3, 15, 20, 7 };
        int preorder[] = { 3, 9, 20, 15, 7 };
        TreeNode root = buildTree(preorder, inorder);
        levelOrder(root);

        TreeNode root2 = buildTree2(preorder, inorder);
        levelOrder(root2);
    }
}
