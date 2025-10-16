import java.util.*;

//Approach Using Map O(n)
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int remainder = ((num % value) + value) % value;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        int i = 0;
        while (true) {
            int r = i % value;

            if (map.getOrDefault(r, 0) == 0) {
                return i;
            }

            map.put(r, map.get(r) - 1);
            i++;
        }
    }
}