import java.util.*;

public class Balance_A_Binary_Search_Tree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(Integer[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == null)
            return null;

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < tree.length) {
            TreeNode current = queue.poll();

            if (i < tree.length && tree[i] != null) {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < tree.length && tree[i] != null) {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void getInorder(TreeNode root, List<TreeNode> inorder) {
        if (root == null)
            return;
        getInorder(root.left, inorder);
        inorder.add(new TreeNode(root.val));
        getInorder(root.right, inorder);
    }

    public static TreeNode buildBST(int left, int right, List<TreeNode> inorder) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode root = inorder.get(mid);
        root.left = buildBST(left, mid - 1, inorder);
        root.right = buildBST(mid + 1, right, inorder);
        return root;
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        getInorder(root, inorder);

        return buildBST(0, inorder.size() - 1, inorder);
    }

    public static void printTree(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasNextLevel = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                    if (node.left != null || node.right != null)
                        hasNextLevel = true;
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
            if (!hasNextLevel)
                break;
        }
    }

    public static void main(String[] args) {
        Integer[] tree = { 1, null, 2, null, 3, null, 4, null, null };

        TreeNode root = buildTree(tree);
        System.out.println("Original Tree:");
        printTree(root);

        TreeNode balanced = balanceBST(root);
        System.out.println("\nBalanced BST:");
        printTree(balanced);
    }
}
