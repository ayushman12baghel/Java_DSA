import java.util.*;

public class Zero_Array_Transformation_III {

    public static int maxRemoval(int[] nums, int[][] queries) {
        int Q = queries.length;
        int n = nums.length;

        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> past = new PriorityQueue<>();// Storing past Indices which can Impact in future

        int j = 0;
        int usedQueries = 0;

        for (int i = 0; i < n; i++) {
            while (j < Q && queries[j][0] == i) {
                maxHeap.offer(queries[j][1]); // Storing last Indices
                j++;
            }

            nums[i] -= past.size(); // checking if we can impact current element from past endings

            while (nums[i] > 0 && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                int ending = maxHeap.poll();
                past.offer(ending);
                nums[i] -= 1;
                usedQueries++;
            }

            if (nums[i] > 0) {
                return -1;
            }

            // clear out past Indices which are outdated
            while (!past.isEmpty() && past.peek() <= i) {
                past.poll();
            }
        }

        return Q - usedQueries;
    }

    public static void main(String args[]) {
        int queries[][] = { { 0, 2 }, { 0, 2 }, { 1, 1 } };
        int nums[] = { 2, 0, 2 };

        System.out.println(maxRemoval(nums, queries));
    }
}
