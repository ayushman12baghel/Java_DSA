import java.util.*;

class Solution {
    int preIndex = 0;

    public Node constructTree(int[] pre, int[] post) {
        // code here
        HashMap<Integer, Integer> postIndex = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postIndex.put(post[i], i);
        }

        return build(pre, post, postIndex, 0, post.length - 1);
    }

    public Node build(int pre[], int post[], HashMap<Integer, Integer> postIndex, int left, int right) {
        if (preIndex >= pre.length || left > right) {
            return null;
        }

        Node root = new Node(pre[preIndex++]);

        if (left == right || preIndex >= pre.length) {
            return root;
        }

        int leftRootValue = pre[preIndex];
        int leftRootIndex = postIndex.get(leftRootValue);

        root.left = build(pre, post, postIndex, left, leftRootIndex);
        root.right = build(pre, post, postIndex, leftRootIndex + 1, right - 1);

        return root;
    }
}