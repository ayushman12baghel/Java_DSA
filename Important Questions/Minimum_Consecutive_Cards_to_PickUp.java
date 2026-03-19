import java.util.*;

// Approach Using HashMap O(n)
class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                minLength = Math.min(minLength, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}