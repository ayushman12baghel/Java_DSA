import java.util.*;

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public static void transformTree(Node root) {
        // code here
        int sum[] = getSum(root);
        solve(root, sum);

        return;
    }

    public static int[] getSum(Node root) {
        if (root == null) {
            return new int[] { 0 };
        }

        return new int[] { getSum(root.left)[0] + getSum(root.right)[0] + root.data };
    }

    public static void solve(Node root, int sum[]) {
        if (root == null) {
            return;
        }

        solve(root.left, sum);
        int oldData = root.data;
        root.data = sum[0] - oldData;
        sum[0] -= oldData;
        solve(root.right, sum);
    }
}