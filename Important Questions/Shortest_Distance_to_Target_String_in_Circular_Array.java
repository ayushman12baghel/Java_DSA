import java.util.*;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            if (words[j].equals(target)) {
                int diff = Math.abs(j - startIndex);
                int dist = Math.min(diff, n - diff);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}