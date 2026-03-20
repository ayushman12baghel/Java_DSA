import java.util.*;

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node predecessor = findPredecessor(root, key);

        Node successor = findSuccessor(root, key);

        return new ArrayList<>(Arrays.asList(predecessor, successor));
    }

    static Node findPredecessor(Node root, int key) {
        Node predecessor = null;
        while (root != null) {
            if (key > root.data) {

                // potential predecessor
                predecessor = root;

                // look for larger predecessors
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }

    // Finding successor of key
    static Node findSuccessor(Node root, int key) {
        Node successor = null;
        while (root != null) {
            if (key < root.data) {

                // potential successor
                successor = root;

                // look for smaller successors
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
}