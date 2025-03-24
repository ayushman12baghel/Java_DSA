import java.util.*;
import java.util.LinkedList;

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

public class Binary_Tree_Right_Side_View {

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

    // Approach 1 By BFS Level Order
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode right = null;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                right = queue.poll();

                if (right.left != null) {
                    queue.offer(right.left);
                }

                if (right.right != null) {
                    queue.offer(right.right);
                }
            }

            list.add(right.val);
        }

        return list;
    }

    // Approach 2 Using DFS Preorder Traversal
    public static List<Integer> rightView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(root, ans, 1);

        return ans;
    }

    public static void dfs(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }

        if (ans.size() < level) {
            ans.add(root.val);
        }

        dfs(root.right, ans, level + 1);
        dfs(root.left, ans, level + 1);
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String args[]) {
        Integer arr[] = { 1, 2, 3, 4, null, null, null, 5 };

        TreeNode root = buildTree(arr);
        levelOrder(root);
        System.out.println(rightView(root));
        System.out.println(rightView2(root));
    }
}
