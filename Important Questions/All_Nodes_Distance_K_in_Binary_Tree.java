import java.util.*;
import java.util.LinkedList;

public class All_Nodes_Distance_K_in_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {

            TreeNode current = queue.remove();

            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            if (i >= nodes.length)
                break;

            if (nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (curr.left != null) {
                map.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                queue.add(curr.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currLevel == k) {
                break;
            }
            currLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parentTrack.get(curr) != null && visited.get(parentTrack.get(curr)) == null) {
                    queue.offer(parentTrack.get(curr));
                    visited.put(parentTrack.get(curr), true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr.val);
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[] nodes = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = buildTree(nodes);

        List<Integer> result = distanceK(root, root.left, 2);
        System.out.println(result);
    }
}
