import java.util.*;

class Solution {
    public int minOperations(String s) {
        Set<Character> set = new HashSet<>();
        int maxOperations = 0;

        for (char c : s.toCharArray()) {
            if (c != 'a') {
                maxOperations = Math.max(maxOperations, (int) ('z') - c + 1);
            }
        }

        return maxOperations;
    }
}