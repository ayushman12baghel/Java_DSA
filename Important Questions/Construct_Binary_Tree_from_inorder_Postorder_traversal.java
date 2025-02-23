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

public class Construct_Binary_Tree_from_inorder_Postorder_traversal {

    // Approach 1 Brute FOrce O(n^2)
    public static TreeNode buildTree(int inorder[], int postorder[]) {
        return solve(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }

    public static TreeNode solve(int inStart, int inEnd, int postStart, int postEnd, int inorder[], int postorder[]) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int j = inStart;
        while (inorder[j] != root.val) {
            j++;
        }

        int leftSize = j - inStart;
        int rightSize = inEnd - j;

        root.left = solve(inStart, j - 1, postStart, postStart + leftSize - 1, inorder, postorder);
        root.right = solve(j + 1, inEnd, postEnd - rightSize, postEnd - 1, inorder, postorder);

        return root;

    }

    // Approach 2 Using HashMap O(n)
    public static TreeNode buildTree2(int inorder[], int postorder[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder, map);
    }

    public static TreeNode solve(int inStart, int inEnd, int postStart, int postEnd, int inorder[], int postorder[],
            HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int j = map.get(root.val);

        int leftSize = j - inStart;
        int rightSize = inEnd - j;

        root.left = solve(inStart, j - 1, postStart, postStart + leftSize - 1, inorder, postorder, map);
        root.right = solve(j + 1, inEnd, postEnd - rightSize, postEnd - 1, inorder, postorder, map);

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

    public static void main(String args[]) {
        int inorder[] = { 9, 3, 15, 20, 7 };
        int postorder[] = { 9, 15, 7, 20, 3 };
        TreeNode root = buildTree(inorder, postorder);
        levelOrder(root);

        TreeNode root2 = buildTree2(inorder, postorder);
        levelOrder(root2);
    }
}
