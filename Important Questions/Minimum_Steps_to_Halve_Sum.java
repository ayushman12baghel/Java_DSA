import java.util.*;

// Approach Using PriorityQueue O(nlogn)
class Solution {
    public int minOperations(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double total = 0;

        for (int num : nums) {
            pq.offer((double) num);
            total += num;
        }

        int operations = 0;
        double half = total / 2.0;

        while (!pq.isEmpty()) {
            double current = pq.poll();
            total -= current;
            double temp = current / 2.0;
            total += temp;
            operations++;
            if (total <= half) {
                return operations;
            }

            pq.offer(temp);
        }

        return operations;
    }
}