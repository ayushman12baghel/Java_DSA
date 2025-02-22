import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Recover_a_Tree_From_Preorder_Traversal {

    public static TreeNode recoverFromPreorder(String traversal) {

        return solve(traversal, new int[1], 0);
    }

    public static TreeNode solve(String str, int index[], int depth) {
        if (index[0] >= str.length()) {
            return null;
        }

        int j = index[0];
        while (j < str.length() && str.charAt(j) == '-') {
            j++;
        }

        int dash = j - index[0];
        if (dash != depth) {
            return null;
        }

        index[0] += dash;
        int num = 0;

        while (index[0] < str.length() && Character.isDigit(str.charAt(index[0]))) {
            num = (num * 10) + (str.charAt(index[0]) - '0');
            index[0]++;
        }

        TreeNode root = new TreeNode(num);
        root.left = solve(str, index, depth + 1);
        root.right = solve(str, index, depth + 1);

        return root;
    }

    public static void main(String args[]) {
        String traversal = "1-2--3--4-5--6--7";

        TreeNode root = recoverFromPreorder(traversal);
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
}
