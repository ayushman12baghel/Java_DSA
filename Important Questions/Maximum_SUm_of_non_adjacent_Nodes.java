import java.util.*;

public class Maximum_SUm_of_non_adjacent_Nodes {

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    static Map<Node, Integer> map = new HashMap<>();

    public static int getMaxSum(Node root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int include = root.data;

        if (root.left != null) {
            include += getMaxSum(root.left.left);
            include += getMaxSum(root.left.right);
        }
        if (root.right != null) {
            include += getMaxSum(root.right.left);
            include += getMaxSum(root.right.right);
        }

        int exclude = getMaxSum(root.left);
        exclude += getMaxSum(root.right);

        int result = Math.max(include, exclude);
        map.put(root, result);

        return result;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println(getMaxSum(root));
    }
}
