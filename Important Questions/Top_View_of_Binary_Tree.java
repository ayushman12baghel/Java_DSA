import java.util.*;

//Approach 1 Using BFS O(n*logn)
class Pair {
    int index;
    Node node;

    public Pair(Node node, int index) {
        this.index = index;
        this.node = node;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int index = current.index;
            Node node = current.node;

            if (!map.containsKey(index)) {
                map.put(index, node.data);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, index - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, index + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}

// Optimising Approach 1 O(n) with min and max Index tracking
class Pair {
    int index;
    Node node;

    public Pair(Node node, int index) {
        this.index = index;
        this.node = node;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0;
        int max = 0;
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int index = current.index;
            Node node = current.node;
            min = Math.min(min, index);
            max = Math.max(max, index);

            if (!map.containsKey(index)) {
                map.put(index, node.data);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, index - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, index + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}