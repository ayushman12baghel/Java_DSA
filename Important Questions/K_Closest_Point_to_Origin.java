import java.util.*;

//O(nlogn)
class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[2], b[2]));

        for (int point[] : points) {
            long dist = (long) point[0] * point[0] + (long) point[1] * point[1];

            pq.offer(new long[] { point[0], point[1], dist });
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            long current[] = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((int) current[0]);
            temp.add((int) current[1]);

            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }
}