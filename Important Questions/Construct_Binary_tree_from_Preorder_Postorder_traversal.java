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

public class Construct_Binary_tree_from_Preorder_Postorder_traversal {

    // O(n^2)
    public static TreeNode constructBinaryTree(int preorder[], int postorder[]) {
        return solve(0, 0, preorder.length - 1, preorder, postorder);
    }

    public static TreeNode solve(int preStart, int postStart, int preEnd, int preorder[], int postorder[]) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int nextNode = preorder[preStart + 1];

        // find it in postorder
        int j = postStart;

        while (postorder[j] != nextNode) {
            j++;
        }

        int leftNodes = j - postStart + 1;

        root.left = solve(preStart + 1, postStart, preStart + leftNodes, preorder, postorder);
        root.right = solve(preStart + leftNodes + 1, j + 1, preEnd, preorder, postorder);

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

    // Aproach 2 using HashMap to store indexes O(n)
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return solve(0, 0, preorder.length - 1, preorder, postorder, map);
    }

    public static TreeNode solve(int preStart, int postStart, int preEnd, int preorder[], int postorder[],
            HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root;
        }
        int nextNode = preorder[preStart + 1];

        // find it in postorder
        int j = map.get(nextNode);

        int num = j - postStart + 1;
        root.left = solve(preStart + 1, postStart, preStart + num, preorder, postorder, map);
        root.right = solve(preStart + num + 1, j + 1, preEnd, preorder, postorder, map);

        return root;
    }

    public static void main(String args[]) {
        int preorder[] = { 1, 2, 4, 5, 3, 6, 7 };
        int postorder[] = { 4, 5, 2, 6, 7, 3, 1 };

        TreeNode root = constructBinaryTree(preorder, postorder);
        levelOrder(root);

        TreeNode root2 = constructFromPrePost(preorder, postorder);
        levelOrder(root2);
    }
}
