import java.util.*;

//Approach Using Difference Array O(n)
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int maxLength = 0;

        for (int i = 0; i < segments.length; i++) {
            maxLength = Math.max(maxLength, segments[i][1]);
        }

        boolean events[] = new boolean[maxLength + 1];
        long diff[] = new long[maxLength + 1];

        for (int segment[] : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];

            events[start] = true;
            events[end] = true;
            diff[start] += color;
            diff[end] -= color;
        }

        List<List<Long>> ans = new ArrayList<>();
        long currentSum = 0;
        long prevIndex = 0;

        for (int i = 0; i < diff.length; i++) {
            if (events[i]) {
                if (currentSum > 0) {
                    List<Long> temp = new ArrayList<>();
                    temp.add(prevIndex);
                    temp.add((long) i);
                    temp.add(currentSum);
                    ans.add(temp);
                }

                prevIndex = i;
            }

            currentSum += diff[i];
        }

        return ans;
    }
}

// Approach 2 Using Line Sweep Method O(nlogn)
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> events = new TreeMap<>();

        for (int segment[] : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];

            events.put(start, events.getOrDefault(start, 0L) + color);
            events.put(end, events.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> ans = new ArrayList<>();
        long currentSum = 0;
        long prevIndex = 0;

        for (Map.Entry<Integer, Long> entry : events.entrySet()) {
            if (currentSum > 0) {
                List<Long> temp = new ArrayList<>();
                temp.add(prevIndex);
                temp.add((long) entry.getKey());
                temp.add(currentSum);
                ans.add(temp);
            }
            prevIndex = entry.getKey();
            currentSum += entry.getValue();
        }

        return ans;
    }
}