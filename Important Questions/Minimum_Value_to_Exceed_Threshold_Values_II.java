import java.util.PriorityQueue;

public class Minimum_Value_to_Exceed_Threshold_Values_II {

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;
        for (int num : nums) {
            pq.offer((long) num);
        }
        while (pq.size() > 1 && pq.peek() < k) {
            count++;
            long first = pq.poll();
            long second = pq.poll();
            pq.offer(first * 2 + second);
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 11, 10, 1, 3 }, k = 10;
        System.out.println(minOperations(nums, k));
    }
}
