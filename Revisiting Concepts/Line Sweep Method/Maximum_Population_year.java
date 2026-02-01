import java.util.*;

// Approach 1 Using Difference Array O(n)
class Solution {
    public int maximumPopulation(int[][] logs) {
        int maxLog = Integer.MIN_VALUE;
        for (int log[] : logs) {
            maxLog = Math.max(maxLog, log[1]);
        }

        int diff[] = new int[maxLog - 1950 + 1];
        for (int log[] : logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

        int currSum = 0;
        int maxSum = 0;
        int maxPopulation = logs[0][0];
        for (int i = 0; i < diff.length; i++) {
            currSum += diff[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                maxPopulation = i + 1950;
            }
        }

        return maxPopulation;
    }
}

// Approach 2 Line Sweep Method O(nlogn)
class Solution {
    public int maximumPopulation(int[][] logs) {
        List<int[]> events = new ArrayList<>();
        for (int log[] : logs) {
            events.add(new int[] { log[0], 1 });
            events.add(new int[] { log[1], -1 });
        }

        Collections.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        int currSum = 0;
        int maxSum = 0;
        int maxPopulation = logs[0][0];
        for (int event[] : events) {
            currSum += event[1];

            if (currSum > maxSum) {
                maxSum = currSum;
                maxPopulation = event[0];
            }
        }

        return maxPopulation;
    }
}