import java.util.*;

public class Choose_K_Elements_with_Maximum_Sum {

    // Brute Force T.L.E T.C=O(n^2*log(k))
    public static long[] findMaxSum(int nums1[], int nums2[], int k) {
        int n = nums1.length;
        long ans[] = new long[n];

        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                if (nums1[i] > nums1[j]) {
                    pq.offer(nums2[j]);// log(k)

                    if (pq.size() > k) {
                        pq.poll();// log(k)
                    }
                }
            }

            int sum = 0;
            while (!pq.isEmpty()) {// k*log(k)
                sum += pq.poll();
            }

            ans[i] = sum;
        }

        return ans;
    }

    // Approach 2 T.C=O(n*log(k))
    public static long[] findMaxSum2(int nums1[], int nums2[], int k) {
        int n = nums1.length;
        int ans[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            ans[i][0] = nums1[i];
            ans[i][1] = i;
            ans[i][2] = nums2[i];
        }

        Arrays.sort(ans, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long result[] = new long[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && ans[i][0] == ans[i - 1][0]) {
                result[ans[i][1]] = result[ans[i - 1][1]];
            } else {
                result[ans[i][1]] = sum;
            }

            sum += ans[i][2];
            pq.offer(ans[i][2]);

            if (pq.size() > k) {
                sum -= pq.poll();
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int nums1[] = { 4, 2, 1, 5, 3 };
        int nums2[] = { 10, 20, 30, 40, 50 };
        int k = 2;

        long ans[] = findMaxSum(nums1, nums2, k);
        for (long ele : ans) {
            System.out.print(ele + " ");
        }
        System.out.println();

        long ans2[] = findMaxSum2(nums1, nums2, k);
        for (long ele : ans2) {
            System.out.print(ele + " ");
        }
    }
}
