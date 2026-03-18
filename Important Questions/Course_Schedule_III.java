import java.util.*;

//Approach Using PriorityQueue O(nlogn)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int totalTime = 0;
        for (int course[] : courses) {
            int duration = course[0];
            int lastDay = course[1];
            totalTime += duration;
            pq.offer(duration);

            if (totalTime > lastDay) {
                totalTime -= pq.poll();
            }
        }

        return pq.size();
    }
}