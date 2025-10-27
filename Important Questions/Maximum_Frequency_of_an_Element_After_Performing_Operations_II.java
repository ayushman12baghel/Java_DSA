import java.util.*;

//Approach Difference Array with TreeMap O(nlogn)
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxElement = Integer.MIN_VALUE;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        maxElement += k;

        TreeMap<Integer, Integer> diff = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            int left = Math.max(0, num - k);
            int right = Math.min(maxElement, num + k);

            diff.put(left, diff.getOrDefault(left, 0) + 1);
            diff.put(right + 1, diff.getOrDefault(right + 1, 0) - 1);

            diff.putIfAbsent(num, diff.getOrDefault(num, 0));
        }

        int cumSum = 0;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int target = entry.getKey();
            int value = entry.getValue();

            cumSum += value;

            int targetCount = map.getOrDefault(target, 0);
            int requiredOperations = cumSum - targetCount;
            int maxFreq = targetCount + Math.min(requiredOperations, numOperations);

            result = Math.max(result, maxFreq);
        }

        return result;
    }
}