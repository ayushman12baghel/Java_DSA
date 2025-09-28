import java.util.*;

//Approach 1 Using Sliding Window and TreeMap O(nlogn)
class Solution {
    public ArrayList<Integer> longestSubarray(int[] nums, int x) {
        int n = nums.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        int bestStart = 0;
        int maxLength = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.lastKey() - map.firstKey() > x) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            if (j - i + 1 > maxLength) {
                maxLength = j - i + 1;
                bestStart = i;
            }

            j++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (i = bestStart; i < bestStart + maxLength; i++) {
            result.add(nums[i]);
        }

        return result;
    }
}

// Approach 2 Using Sliding Window and Deque O(n)
class Solution {
    public ArrayList<Integer> longestSubarray(int[] nums, int x) {
        int n = nums.length;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int bestStart = 0;
        int maxLength = 0;

        while (j < n) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[j]) {
                minDeque.pollLast();
            }

            minDeque.offerLast(j);

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[j]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(j);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > x) {
                if (i == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }

                if (i == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }

                i++;
            }

            if (j - i + 1 > maxLength) {
                maxLength = j - i + 1;
                bestStart = i;
            }

            j++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (i = bestStart; i < bestStart + maxLength; i++) {
            result.add(nums[i]);
        }

        return result;
    }
}