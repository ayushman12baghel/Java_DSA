import java.util.*;

// Approach 1 Using BFS and Building Graph O(n)
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
    public int minTime(Node root, int target) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    graph.computeIfAbsent(current.data, k -> new ArrayList<>()).add(current.left.data);
                    graph.computeIfAbsent(current.left.data, k -> new ArrayList<>()).add(current.data);
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    graph.computeIfAbsent(current.data, k -> new ArrayList<>()).add(current.right.data);
                    graph.computeIfAbsent(current.right.data, k -> new ArrayList<>()).add(current.data);
                    queue.offer(current.right);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                int current = q.poll();

                for (int neighbour : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbour)) {
                        q.offer(neighbour);
                        visited.add(neighbour);
                        burned = true;
                    }
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }
}

// Approach 2 Using Track of Parent O(n)

class Solution {
    public int minTime(Node root, int target) {
        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node targetNode = null;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.data == target) {
                    targetNode = current;
                }

                if (current.left != null) {
                    parent.put(current.left, current);
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    parent.put(current.right, current);
                    queue.offer(current.right);
                }
            }
        }

        Set<Node> visited = new HashSet<>();
        queue.offer(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                    burned = true;
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                    burned = true;
                }

                if (parent.containsKey(current) && !visited.contains(parent.get(current))) {
                    queue.offer(parent.get(current));
                    visited.add(parent.get(current));
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }
}