import java.util.*;

// Greedy Approach of Grouping 
class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();

        int count = 0;
        int currentGroup = 1;
        int prevGroup = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroup++;
            } else {
                count += Math.min(currentGroup, prevGroup);
                prevGroup = currentGroup;
                currentGroup = 1;
            }
        }

        count += Math.min(currentGroup, prevGroup);

        return count;
    }
}