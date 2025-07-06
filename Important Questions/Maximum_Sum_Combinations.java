import java.util.*;

public class Maximum_Sum_Combinations {

    // Using PriorityQueue O(nlogn)
    public static ArrayList<Integer> topKSumPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        Set<String> visited = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        pq.offer(new int[] { n - 1, n - 1, nums1[n - 1] + nums2[n - 1] });
        visited.add((n - 1) + "," + (n - 1));

        while (k-- > 0 && !pq.isEmpty()) {
            int current[] = pq.poll();
            int i = current[0];
            int j = current[1];
            int cost = current[2];

            ans.add(cost);

            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                pq.offer(new int[] { i - 1, j, nums1[i - 1] + nums2[j] });
                visited.add((i - 1) + "," + j);
            }
            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                pq.offer(new int[] { i, j - 1, nums1[i] + nums2[j - 1] });
                visited.add(i + "," + (j - 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 4, 2, 3 };
        int nums2[] = { 2, 5, 1, 6 };
        int k = 3;

        System.out.println(topKSumPairs(nums1, nums2, k));
    }
}
