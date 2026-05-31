import java.util.*;

//Approach 1 Using TreeMap O(nlogn)
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long currentMass = mass;

        while (!map.isEmpty()) {
            int searchKey = (int) Math.min(currentMass, Integer.MAX_VALUE);
            Integer prev = map.floorKey(searchKey);

            if (prev == null) {
                return false;
            }

            currentMass += prev;
            map.put(prev, map.get(prev) - 1);
            if (map.get(prev) == 0) {
                map.remove(prev);
            }
        }

        return true;
    }
}

// Approach 2 Greedy and Sorting O(nlogn)
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] nums) {
        long currentMass = mass;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (currentMass >= nums[i]) {
                currentMass += nums[i];
            } else {
                return false;
            }
        }

        return true;
    }
}