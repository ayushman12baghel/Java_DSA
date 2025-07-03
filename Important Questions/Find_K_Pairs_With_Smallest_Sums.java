import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Find_K_Pairs_With_Smallest_Sums {

    // Approach 1 Using Optimised Brute Force O(n*m*log(k))
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (pq.size() < k) {
                    pq.offer(new int[] { nums1[i], nums2[j], sum });
                } else if (pq.peek()[2] > sum) {
                    pq.poll();
                    pq.offer(new int[] { nums1[i], nums2[j], sum });
                } else {
                    break;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int current[] = pq.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(current[0]);
            temp.add(current[1]);
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }

    // Approach 2 O(min(k, m × n) * log k)
    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<String> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        pq.offer(new int[] { 0, 0, nums1[0] + nums2[0] });
        set.add(0 + "," + 0);

        while (k > 0 && !pq.isEmpty()) {
            int current[] = pq.poll();
            int i = current[0];
            int j = current[1];
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !set.contains((i + 1) + "," + j)) {
                pq.offer(new int[] { i + 1, j, nums1[i + 1] + nums2[j] });
                set.add((i + 1) + "," + j);
            }
            if (j + 1 < nums2.length && !set.contains(i + "," + (j + 1))) {
                pq.offer(new int[] { i, j + 1, nums1[i] + nums2[j + 1] });
                set.add(i + "," + (j + 1));
            }

            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 7, 11 };
        int nums2[] = { 2, 4, 6 };
        int k = 3;

        System.out.println(kSmallestPairs(nums1, nums2, k));
        System.out.println(kSmallestPairs2(nums1, nums2, k));
    }
}
