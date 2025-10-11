import java.util.*;

/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

//O(n)
class Solution {
    int maxSum = Integer.MIN_VALUE;

    int findMaxSum(Node root) {
        // code here
        solve(root);

        return maxSum;
    }

    int solve(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        int all = leftSum + rightSum + root.data;
        int onlyRoot = root.data;
        int chooseOne = Math.max(leftSum, rightSum) + root.data;

        maxSum = Math.max(maxSum, Math.max(all, Math.max(onlyRoot, chooseOne)));

        return Math.max(onlyRoot, chooseOne);
    }
}