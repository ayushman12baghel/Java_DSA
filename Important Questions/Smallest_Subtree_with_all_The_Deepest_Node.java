import java.util.*;

import javax.swing.tree.TreeNode;

public class Smallest_Subtree_with_all_The_Deepest_Node {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(Integer tree[]) {
        if (tree[0] == null || tree.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < tree.length) {
            TreeNode current = queue.poll();

            if (i < tree.length && tree[i] != null) {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < tree.length && tree[i] != null) {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        int height = height(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            height--;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    if (height == 1) {
                        list.add(current.left);
                    }
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    if (height == 1) {
                        list.add(current.right);
                    }
                    queue.offer(current.right);
                }
            }
        }

        if (list.size() == 0) {
            return root;
        }

        TreeNode result = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            result = lca(root, result, list.get(i));
        }

        return result;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String args[]) {
        Integer tree[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = buildTree(tree);

        System.out.println(subtreeWithAllDeepest(root).value);
    }
}

// Same as above but another try O(n)

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        int height = getHeight(root);

        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> endNodes = new ArrayList<>();
        HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (level == height) {
                    endNodes.add(current);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                    childToParent.put(current.left, current);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                    childToParent.put(current.right, current);
                }
            }
        }

        Set<TreeNode> currentLevelNodes = new HashSet<>(endNodes);

        while (currentLevelNodes.size() > 1) {
            Set<TreeNode> newLevelNodes = new HashSet<>();

            for (TreeNode node : currentLevelNodes) {
                TreeNode parent = childToParent.get(node);

                if (parent != null) {
                    newLevelNodes.add(parent);
                }
            }

            currentLevelNodes = newLevelNodes;
        }

        return currentLevelNodes.iterator().next();
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

// Approach 3 One Pass O(n) asking each node what is the deepest height in your
// subtree ? and what is the lca of the deepest node
class Solution {
    class Pair {
        int depth;
        TreeNode node;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        return solve(root).node;
    }

    public Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else if (left.depth < right.depth) {
            return new Pair(right.node, right.depth + 1);
        } else {
            return new Pair(root, left.depth + 1);
        }
    }
}