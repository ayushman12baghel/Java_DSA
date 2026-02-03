import java.util.*;

// Approach Using BFS and tracking of Parents O(n)
// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        Map<Node, Node> parent = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        Node targetA = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == a) {
                targetA = current;
            }

            if (current.left != null) {
                queue.offer(current.left);
                parent.put(current.left, current);
            }

            if (current.right != null) {
                queue.offer(current.right);
                parent.put(current.right, current);
            }
        }

        int dist = 0;
        queue.offer(targetA);
        Set<Node> visited = new HashSet<>();
        visited.add(targetA);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.data == b) {
                    return dist;
                }

                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                if (parent.containsKey(current) && !visited.contains(parent.get(current))) {
                    queue.offer(parent.get(current));
                    visited.add(parent.get(current));
                }
            }

            dist++;
        }

        return dist;
    }
}