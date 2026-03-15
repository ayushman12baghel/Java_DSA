import java.util.*;

//Approach Using HashMap O(n)
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    class Pair {
        Node node;
        int index;

        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int index = p.index;
            Node node = p.node;

            min = Math.min(min, index);
            max = Math.max(max, index);
            map.computeIfAbsent(index, k -> new ArrayList<>()).add(node.data);

            if (node.left != null) {
                queue.offer(new Pair(node.left, index - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, index + 1));
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}