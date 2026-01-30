import java.util.*;

// Approach Greedy Doing Sorting O(nlogn)
class Solution {
    public int maxMeetings(int start[], int end[]) {
        int meetings[][] = new int[start.length][2];
        for (int i = 0; i < start.length; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1;
        int endTime = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] > endTime) {
                count++;
                endTime = Math.max(meetings[i][1], endTime);
            }
        }

        return count;
    }
}
