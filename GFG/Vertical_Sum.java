import java.util.*;

// Approach 1 Using HashMap O(n)
class Solution {
    class Pair {
        Node node;
        int index;

        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public ArrayList<Integer> verticalSum(Node root) {
        Map<Integer, Integer> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int index = current.index;
            max = Math.max(max, index);
            min = Math.min(min, index);

            map.put(index, map.getOrDefault(index, 0) + node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, index - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, index + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}

// Approach 2 Using Doubly LinkedList O(n)
class Solution {
    class DLL {
        int data;
        DLL next;
        DLL prev;

        public DLL(int data) {
            this.data = data;
        }
    }

    public ArrayList<Integer> verticalSum(Node root) {
        DLL head = new DLL(0);

        solve(root, head);

        while (head.prev != null) {
            head = head.prev;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (head != null) {
            ans.add(head.data);
            head = head.next;
        }

        return ans;
    }

    public void solve(Node root, DLL current) {
        if (root == null) {
            return;
        }

        current.data += root.data;

        if (root.left != null) {
            if (current.prev == null) {
                current.prev = new DLL(0);
                current.prev.next = current;
            }

            solve(root.left, current.prev);
        }

        if (root.right != null) {
            if (current.next == null) {
                current.next = new DLL(0);
                current.next.prev = current;
            }

            solve(root.right, current.next);
        }
    }
}