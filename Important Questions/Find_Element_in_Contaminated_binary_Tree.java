import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Approach 1 Using DFS
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        init(root, 0);
    }

    public void init(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        root.val = val;

        init(root.left, 2 * val + 1);
        init(root.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return dfs(root, target);
    }

    public boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        return dfs(root.left, target) || dfs(root.right, target);
    }
}

// Approach 2 Using Set to store the elements
class FindElements {
    TreeNode root;
    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        this.root = root;
        init(root, 0);
    }

    public void init(TreeNode root, int x) {
        if (root == null) {
            return;
        }

        root.val = x;
        set.add(x);
        init(root.left, 2 * x + 1);
        init(root.right, 2 * x + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

// Approach 3 Using BFS
class FindElements {
    TreeNode root;
    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        this.root = root;
        init(root, 0);
    }

    public void init(TreeNode root, int x) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = x;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            set.add(temp.val);
            if (temp.left != null) {
                temp.left.val = 2 * temp.val + 1;
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                temp.right.val = 2 * temp.val + 2;
                queue.offer(temp.right);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

public class Find_Element_in_Contaminated_binary_Tree {
    public static void main(String[] args) {
        // Creating a sample corrupted tree (all values initially -1)
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);

        // Initialize FindElements and reconstruct the tree
        FindElements obj = new FindElements(root);

        // Test find method
        System.out.println(obj.find(1)); // Output: true (since 1 = 2 * 0 + 1)
        System.out.println(obj.find(2)); // Output: true (since 2 = 2 * 0 + 2)
        System.out.println(obj.find(4)); // Output: true (since 5 = 2 * 2 + 1)
        System.out.println(obj.find(10)); // Output: false (not present in tree)
    }
}
