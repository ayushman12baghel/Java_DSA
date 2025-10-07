import java.util.*;

//Approach 1 O(nlogn)
class Pair {
    Node node;
    int dist;

    public Pair(Node node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer, Node> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(root, 0));
        map.put(0, root);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int dist = current.dist;

            if (node.left != null) {
                queue.offer(new Pair(node.left, dist - 1));
                map.put(dist - 1, node.left);
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, dist + 1));
                map.put(dist + 1, node.right);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }

        return ans;
    }
}

// Approach 2 O(n)
class Pair {
    Node node;
    int dist;

    public Pair(Node node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer, Node> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(root, 0));
        map.put(0, root);
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int dist = current.dist;
            minDist = Math.min(dist, minDist);
            maxDist = Math.max(dist, maxDist);

            if (node.left != null) {
                queue.offer(new Pair(node.left, dist - 1));
                map.put(dist - 1, node.left);
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, dist + 1));
                map.put(dist + 1, node.right);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = minDist; i <= maxDist; i++) {
            ans.add(map.get(i).data);
        }

        return ans;
    }
}