import java.util.*;

//Approach O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current == null) {
                    sb.append("n,");
                    continue;
                }

                sb.append(current.val).append(',');
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String nums[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < nums.length) {
            TreeNode current = queue.poll();

            if (!nums[i].equals("n")) {
                current.left = new TreeNode(Integer.parseInt(nums[i]));
                queue.offer(current.left);
            }

            i++;

            if (i < nums.length && !nums[i].equals("n")) {
                current.right = new TreeNode(Integer.parseInt(nums[i]));
                queue.offer(current.right);
            }

            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));