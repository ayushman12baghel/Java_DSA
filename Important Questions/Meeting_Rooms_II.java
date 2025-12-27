import java.util.*;

// Approach Sorting and PriorityQueue O(nlogn)
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
