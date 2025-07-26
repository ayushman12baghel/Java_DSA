import java.util.*;

public class Most_Profit_Assigning_Work {

    // Approach 1 Using PriorityQueue O(nlogn)
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { profit[i], difficulty[i] });
        }

        Arrays.sort(worker);

        int i = m - 1;
        int totalProfit = 0;

        while (i >= 0 && !pq.isEmpty()) {
            if (pq.peek()[1] > worker[i]) {
                pq.poll();
            } else {
                totalProfit += pq.peek()[0];
                i--;
            }
        }

        return totalProfit;
    }

    // Approach 2 Sorting and Preprocessing
    public static int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        int nums[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = difficulty[i];
            nums[i][1] = profit[i];
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < n; i++) {
            nums[i][1] = Math.max(nums[i][1], nums[i - 1][1]);
        }

        int totalProfit = 0;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = nums.length - 1;
            int maxProfit = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid][0] <= worker[i]) {
                    maxProfit = Math.max(maxProfit, nums[mid][1]);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }

    // Approach 3
    public static int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        int nums[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = difficulty[i];
            nums[i][1] = profit[i];
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int totalProfit = 0;
        int maxProfit = 0;
        int j = 0;

        for (int i = 0; i < m; i++) {
            while (j < n && worker[i] >= nums[j][0]) {
                maxProfit = Math.max(maxProfit, nums[j][1]);
                j++;
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int difficulty[] = { 2, 4, 6, 8, 10 }, profit[] = { 10, 20, 30, 40, 50 }, worker[] = { 4, 5, 6, 7 };
    }
}
