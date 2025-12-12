import java.util.*;

//Approach 1 Using DFS
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node cloneNode = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, cloneNode);

        dfs(node, cloneNode, map);

        return cloneNode;
    }

    public void dfs(Node node, Node clone, Map<Node, Node> map) {
        for (Node neigh : node.neighbors) {
            if (!map.containsKey(neigh)) {
                Node newNeigh = new Node(neigh.val);
                map.put(neigh, newNeigh);
                clone.neighbors.add(newNeigh);
                dfs(neigh, newNeigh, map);
            } else {
                clone.neighbors.add(map.get(neigh));
            }
        }
    }
}

// Approach 2 Using BFS O(n)
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node cloneNode = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, cloneNode);

        bfs(node, map);

        return cloneNode;
    }

    public void bfs(Node node, Map<Node, Node> map) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node currentClone = map.get(current);

            for (Node neigh : current.neighbors) {
                if (!map.containsKey(neigh)) {
                    Node newNeigh = new Node(neigh.val);
                    map.put(neigh, newNeigh);
                    currentClone.neighbors.add(newNeigh);
                    queue.offer(neigh);
                } else {
                    currentClone.neighbors.add(map.get(neigh));
                }
            }
        }
    }
}