import java.util.*;

//Approach Using property of BST and BFS O(n)
class Solution {
    public int nodeSum(Node root, int l, int r) {
        // code here
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        int sum = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.data >= l && current.data <= r) {
                sum += current.data;
            }

            if (current.data > l && current.left != null) {
                queue.offer(current.left);
            }

            if (current.data < r && current.right != null) {
                queue.offer(current.right);
            }
        }

        return sum;
    }
}