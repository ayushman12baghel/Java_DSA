import java.util.*;

//O(n)
class Solution {
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current == null) {
                    ans.add(-1);
                    continue;
                }

                ans.add(current.data);
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return ans;
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return null;
        }

        Node root = new Node(arr.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.size()) {
            Node current = queue.poll();

            if (arr.get(i) != -1) {
                current.left = new Node(arr.get(i));
                queue.offer(current.left);
            }

            i++;

            if (i < arr.size() && arr.get(i) != -1) {
                current.right = new Node(arr.get(i));
                queue.offer(current.right);
            }

            i++;
        }

        return root;
    }
};