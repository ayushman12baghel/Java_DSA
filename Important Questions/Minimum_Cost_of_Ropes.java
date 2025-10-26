import java.util.*;

//Using PrioritQueue O(nlogn)
class Solution {
    public static int minCost(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        for (int num : nums) {
            pq.offer(num);
        }

        while (pq.size() > 2) {
            int current1 = pq.poll();
            int current2 = pq.poll();

            cost += (current1 + current2);

            pq.offer(current1 + current2);
        }

        cost += pq.poll();
        cost += pq.poll();

        return cost;
    }
}