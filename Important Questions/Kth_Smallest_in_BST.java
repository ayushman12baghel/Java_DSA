import java.util.*;

//Approach Using DFS with Early Stopping O(n)
/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int kthSmallest(Node root, int k) {
        int ans[] = new int[2];
        ans[0] = 0;
        ans[1] = -1;

        solve(root, k, ans);

        return ans[1];
    }

    public void solve(Node root, int k, int ans[]) {
        if (root == null) {
            return;
        }
        if (ans[0] >= k) {
            return;
        }

        solve(root.left, k, ans);
        ans[0]++;
        if (ans[0] == k) {
            ans[1] = root.data;
        }

        solve(root.right, k, ans);
    }
}