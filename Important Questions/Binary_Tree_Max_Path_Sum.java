import java.util.*;

class TreeNode {
    TreeNode right;
    TreeNode left;
    int val;

    public TreeNode(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class Binary_Tree_Max_Path_Sum {

    public static TreeNode buildTree(Integer arr[]) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);

        return maxSum;
    }

    public static int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int neecheMilGaya = root.val + left + right;
        int koiEkAccha = root.val + Math.max(left, right);
        int onlyRootAccha = root.val;

        maxSum = Math.max(maxSum, Math.max(neecheMilGaya, Math.max(koiEkAccha, onlyRootAccha)));

        return Math.max(koiEkAccha, onlyRootAccha);
    }

    public static void main(String args[]) {
        Integer arr[] = { -10, 9, 20, null, null, 15, 7 };
        TreeNode root = buildTree(arr);

        System.out.println(maxPathSum(root));
    }
}
