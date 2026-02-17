import java.util.*;

//Approach 1 Sorting O(nlogn)
class Solution {
    public static int overlapInt(int[][] nums) {
        int n = nums.length;

        int start[] = new int[n];
        int end[] = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = nums[i][0];
            end[i] = nums[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int current = 0;
        int max = 0;

        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                current++;
                i++;
            } else {
                current--;
                j++;
            }

            max = Math.max(max, current);
        }

        return max;
    }
}

// Approach 2 Using Difference Array O(n)

class Solution {
    public static int overlapInt(int[][] nums) {
        int maxValue = 0;

        for (int num[] : nums) {
            maxValue = Math.max(num[1], maxValue);
        }

        int diff[] = new int[maxValue + 2];

        for (int num[] : nums) {
            diff[num[0]]++;
            diff[num[1] + 1]--;
        }

        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < diff.length; i++) {
            currentSum += diff[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

// Approach 3 Using Line Sweep O(nlogn)

class Solution {
    public static int overlapInt(int[][] nums) {
        TreeMap<Integer, Integer> events = new TreeMap<>();

        for (int num[] : nums) {
            events.put(num[0], events.getOrDefault(num[0], 0) + 1);
            events.put(num[1] + 1, events.getOrDefault(num[1] + 1, 0) - 1);
        }

        int currentSum = 0;
        int maxSum = 0;

        for (int value : events.values()) {
            currentSum += value;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
