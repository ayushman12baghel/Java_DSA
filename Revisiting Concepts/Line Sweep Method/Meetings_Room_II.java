import java.util.*;

// Approach 1 Using Difference Array O(n)
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int diff[] = new int[1000002];
        for (int i = 0; i < start.length; i++) {
            diff[start[i]]++;
            diff[end[i]]--;
        }

        int maxSum = 0;
        int currSum = 0;

        for (int i = 0; i < diff.length; i++) {
            currSum += diff[i];
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}

// Approach 2 Using Line Sweep Method O(nlogn)
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            events.add(new int[] { start[i], 1 });
            events.add(new int[] { end[i], -1 });
        }

        Collections.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        int currSum = 0;
        int maxSum = 0;

        for (int event[] : events) {
            currSum += event[1];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

// Approach 3 Optimised Line Sweep or Two Pointer O(nlogn)
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int currSum = 0;
        int maxSum = 0;

        while (i < start.length && j < start.length) {
            if (start[i] < end[j]) {
                currSum++;
                i++;
            } else {
                currSum--;
                j++;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

// Approach 4 Using PriorityQueue O(nlogn)
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        int nums[][] = new int[start.length][2];
        for (int i = 0; i < start.length; i++) {
            nums[i][0] = start[i];
            nums[i][1] = end[i];
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(nums[0][1]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] >= pq.peek()) {
                pq.poll();
            }

            pq.offer(nums[i][1]);
        }

        return pq.size();
    }
}
