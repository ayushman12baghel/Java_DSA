import java.util.*;

// O(n)
class Solution {
    public Node sortedArrayToBST(int[] arr) {
        return solve(arr, 0, arr.length - 1);
    }

    public Node solve(int nums[], int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        Node root = new Node(nums[mid]);
        root.left = solve(nums, left, mid - 1);
        root.right = solve(nums, mid + 1, right);

        return root;
    }
}