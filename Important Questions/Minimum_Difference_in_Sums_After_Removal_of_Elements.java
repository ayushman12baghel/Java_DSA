import java.util.*;

public class Minimum_Difference_in_Sums_After_Removal_of_Elements {

    // Approach PriorityQueue O(nlogn)
    public static long minimumDifference(int nums[]) {
        int n = nums.length / 3;

        long leftMinSum[] = new long[nums.length];
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        long leftSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            leftSum += nums[i];
            maxHeap.offer((long) nums[i]);

            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }

            if (i >= n - 1) {
                leftMinSum[i] = leftSum;
            }
        }

        long rightMaxSum[] = new long[nums.length];
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long rightSum = 0;

        for (int i = nums.length - 1; i >= n; i--) {
            rightSum += nums[i];
            minHeap.offer((long) nums[i]);

            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }

            if (i <= 2 * n) {
                rightMaxSum[i] = rightSum;
            }
        }

        long minDifference = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            minDifference = Math.min(minDifference, leftMinSum[i] - rightMaxSum[i + 1]);
        }

        return minDifference;
    }

    public static void main(String[] args) {
        int nums[] = { 7, 9, 5, 8, 1, 3 };

        System.out.println(minimumDifference(nums));
    }
}
