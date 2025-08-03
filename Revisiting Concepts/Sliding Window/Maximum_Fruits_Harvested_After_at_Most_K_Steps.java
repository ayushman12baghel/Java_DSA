import java.util.*;

public class Maximum_Fruits_Harvested_After_at_Most_K_Steps {

    // Approach 1 Using Binary Search and Searching
    public static int maxTotalFruits(int fruits[][], int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int prefixSum[] = new int[n];
        int indices[] = new int[n];
        prefixSum[0] = fruits[0][1];
        indices[0] = fruits[0][0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + fruits[i][1];
            indices[i] = fruits[i][0];
        }

        for (int d = 0; d <= k / 2; d++) {

            // case 1 Going left first
            int i = startPos - d;
            int remain = k - 2 * d;
            int j = startPos + remain;

            int left = lowerBound(indices, i);
            int right = upperBound(indices, j) - 1;

            if (left <= right) {
                int total = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
                maxFruits = Math.max(maxFruits, total);
            }

            // case 2 Going right First
            j = startPos + d;
            i = startPos - remain;

            left = lowerBound(indices, i);
            right = upperBound(indices, j) - 1;

            if (left <= right) {
                int total = prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
                maxFruits = Math.max(maxFruits, total);
            }
        }

        return maxFruits;
    }

    public static int lowerBound(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int upperBound(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Optimal Approach Using SLiding Window O(n)
    public static int maxTotalFruits2(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int currentSum = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            currentSum += fruits[j][1];

            while (i <= j && Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - fruits[j][0]))
                    + Math.abs(fruits[j][0] - fruits[i][0]) > k) {
                currentSum -= fruits[i][1];
                i++;
            }

            maxFruits = Math.max(maxFruits, currentSum);

            j++;
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int fruits[][] = { { 0, 9 }, { 4, 1 }, { 5, 7 }, { 6, 2 }, { 7, 4 }, { 10, 9 } };
        int startPos = 5, k = 4;

        System.out.println(maxTotalFruits(fruits, startPos, k));
        System.out.println(maxTotalFruits2(fruits, startPos, k));
    }
}
