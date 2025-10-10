import java.util.*;

/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean isLeft = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                temp.add(current.data);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (isLeft) {
                ans.addAll(temp);
            } else {
                Collections.reverse(temp);
                ans.addAll(temp);
            }

            isLeft = !isLeft;
        }

        return ans;
    }
}