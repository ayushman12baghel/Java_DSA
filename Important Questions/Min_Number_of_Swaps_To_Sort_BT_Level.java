import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class Min_Number_of_Swaps_To_Sort_BT_Level {

    static class TreeNode {
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

    public static TreeNode buildTree(Integer values[], int index) {
        if (index >= values.length || values[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[index]);
        root.left = buildTree(values, 2 * index + 1);
        root.right = buildTree(values, 2 * index + 2);

        return root;
    }

    public static int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int level[] = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                level[i] = temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            count += getSwaps(level);
        }

        return count;
    }

    public static int getSwaps(int arr[]) {
        int swaps = 0;
        int ans[] = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(ans);

        for (int i = 0; i < ans.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < ans.length; i++) {
            if (arr[i] != ans[i]) {
                swaps++;

                int temp = map.get(ans[i]);
                map.put(arr[i], temp);
                arr[temp] = arr[i];
            }
        }

        return swaps;
    }

    public static void main(String args[]) {
        Integer[] values = { 1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10 };
        TreeNode root = buildTree(values, 0);

        System.out.println(minimumOperations(root));
    }
}
