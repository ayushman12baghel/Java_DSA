import java.util.*;

//Approach 1 O(n*m)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int usedCount[] = new int[n];
        long willAvailable[] = new long[n];

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            boolean found = false;
            long earlyAvailable = Long.MAX_VALUE;
            int earlyIndex = 0;

            for (int room = 0; room < n; room++) {
                if (willAvailable[room] <= start) {
                    willAvailable[room] = end;
                    found = true;
                    usedCount[room]++;
                    break;
                }

                if (earlyAvailable > willAvailable[room]) {
                    earlyAvailable = willAvailable[room];
                    earlyIndex = room;
                }
            }

            if (!found) {
                willAvailable[earlyIndex] += (end - start);
                usedCount[earlyIndex] += 1;
            }
        }

        int resultRoom = 0;
        int maxUse = -1;

        for (int i = 0; i < n; i++) {
            if (maxUse < usedCount[i]) {
                maxUse = usedCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}

// Approach 2 Using PriorityQueue O(nlogn...)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int usedCount[] = new int[n];
        var usedRooms = new PriorityQueue<long[]>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        var unusedRooms = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            unusedRooms.add(i);
        }

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.add(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.add(new long[] { end, room });
                usedCount[room]++;
            } else {
                int room = (int) usedRooms.peek()[1];
                long endTime = usedRooms.poll()[0];
                usedRooms.add(new long[] { endTime + (end - start), room });
                usedCount[room]++;
            }
        }

        int resultRoom = 0;
        int maxUse = -1;

        for (int i = 0; i < n; i++) {
            if (maxUse < usedCount[i]) {
                maxUse = usedCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}