/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

import java.util.*;

class Solution {
    int preIndex;
    HashMap<Integer, Integer> pos;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        pos = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            pos.put(preMirror[i], i);
        }

        return build(pre, preMirror, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int[] preMirror, int l, int r) {
        if (preIndex >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == r || preIndex >= pre.length)
            return root;

        // Next preorder element is root of left subtree
        int idx = pos.get(pre[preIndex]);

        // In mirror preorder:
        // root | mirror(right) | mirror(left)
        root.left = build(pre, preMirror, idx, r);
        root.right = build(pre, preMirror, l + 1, idx - 1);

        return root;
    }
}
