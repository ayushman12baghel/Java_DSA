import java.util.*;

// Approach O(n)
class Solution {
    static int solve(Node node, int k, int currSum, HashMap<Integer, Integer> prefSums) {
        if (node == null)
            return 0;

        int pathCount = 0;
        currSum += node.data;

        if (currSum == k)
            pathCount++;

        pathCount += prefSums.getOrDefault(currSum - k, 0);

        prefSums.put(currSum, prefSums.getOrDefault(currSum, 0) + 1);

        pathCount += solve(node.left, k, currSum, prefSums);
        pathCount += solve(node.right, k, currSum, prefSums);

        prefSums.put(currSum, prefSums.get(currSum) - 1);

        return pathCount;
    }

    static int countAllPaths(Node root, int k) {
        HashMap<Integer, Integer> prefSums = new HashMap<>();

        return solve(root, k, 0, prefSums);
    }
}