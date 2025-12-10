import java.util.*;

//Approach 1 Storing inorder Traversal 
// T.C -> O(n) && Space -> O(n)
class BSTIterator {
    List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        fillList(root);
        index = 0;
    }

    public void fillList(TreeNode root) {
        if (root == null) {
            return;
        }
        fillList(root.left);
        list.add(root.val);
        fillList(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}

// Approach 2 Using Stack
// T.C -> O(n) && Space -> O(H)
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAll(root);
    }

    public int next() {
        TreeNode next = stack.pop();
        addAll(next.right);
        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void addAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}