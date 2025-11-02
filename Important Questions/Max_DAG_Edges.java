import java.util.*;

class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {

        int maxPossibleEdges = V * (V - 1) / 2;

        // Subtract existing edges to get how many more we can add
        return maxPossibleEdges - edges.length;
    }
}