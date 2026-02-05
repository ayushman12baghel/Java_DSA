import java.util.*;

// Approach 1 Using Difference Array O(n)
class Solution {
    public int minPlatform(int nums[], int dep[]) {
        int n = nums.length;

        int diff[] = new int[2400];

        for (int i = 0; i < n; i++) {
            diff[nums[i]]++;
            diff[dep[i] + 1]--;
        }

        int currSum = 0;
        int maxSum = 0;

        for (int i = 0; i < diff.length; i++) {
            currSum += diff[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

// Approach 2 Line Sweep O(nlogn)
class Solution {
    public int minPlatform(int nums[], int dep[]) {
        int n = nums.length;

        TreeMap<int[], Integer> events = new TreeMap<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int current[] = new int[] { nums[i], i };
            events.put(current, events.getOrDefault(current, 0) + 1);
            current = new int[] { dep[i] + 1, i };
            events.put(current, events.getOrDefault(current, 0) - 1);
        }

        int currSum = 0;
        int maxSum = 0;

        for (int value : events.values()) {
            currSum += value;
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}

// Approach 3 Using Sorting + Two Pointer O(nlogn)
class Solution {
    public int minPlatform(int nums[], int dep[]) {
        Arrays.sort(nums);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int count = 0;
        int maxCount = 0;

        while (i < nums.length && j < dep.length) {
            if (nums[i] <= dep[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            } else {
                count--;
                j++;
            }
        }

        return maxCount;
    }
}
