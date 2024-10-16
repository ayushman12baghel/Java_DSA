import java.util.*;

public class Path_Sum_II {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insertLevelOrder(Node root, Integer nodes[], int i, int n) {
        if (i < n && nodes[i] != null) {
            root = new Node(nodes[i]);
            root.left = insertLevelOrder(root.left, nodes, 2 * i + 1, n);
            root.right = insertLevelOrder(root.right, nodes, 2 * i + 2, n);
        }
        return root;
    }

    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        hasPath(root, targetSum, list, new ArrayList<>());
        return list;
    }

    public static void hasPath(Node root, int targetSum, List<List<Integer>> list, List<Integer> curr) {
        if (root == null) {
            return;
        }
        curr.add(root.data);
        if (root.left == null && root.right == null && root.data == targetSum) {
            list.add(new ArrayList<>(curr));
        } else {
            hasPath(root.left, targetSum - root.data, list, curr);
            hasPath(root.right, targetSum - root.data, list, curr);
        }

        curr.remove(curr.size() - 1);
    }

    public static void main(String args[]) {
        Node root = null;
        Integer nodes[] = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
        root = insertLevelOrder(root, nodes, 0, nodes.length);

        List<List<Integer>> list = pathSum(root, 22);

        System.out.println(list.size());
        for (List<Integer> curr : list) {
            System.out.println(curr);
        }
    }
}
