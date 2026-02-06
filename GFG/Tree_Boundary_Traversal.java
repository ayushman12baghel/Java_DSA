import java.util.*;

// Approach First Putting leftBoundary Nodes then leafNodes and at Last the
// rightBoundary Nodes
class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        addLeftBoundary(root.left, ans);
        addLeafNode(root, ans);
        addRightBoundary(root.right, ans);

        return ans;
    }

    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public void addLeftBoundary(Node root, ArrayList<Integer> ans) {
        while (root != null) {
            if (!isLeaf(root)) {
                ans.add(root.data);
            }

            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public void addLeafNode(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.data);
        }

        addLeafNode(root.left, ans);
        addLeafNode(root.right, ans);
    }

    public void addRightBoundary(Node root, ArrayList<Integer> ans) {
        ArrayList<Integer> temp = new ArrayList<>();

        while (root != null) {
            if (!isLeaf(root)) {
                temp.add(root.data);
            }

            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }
}