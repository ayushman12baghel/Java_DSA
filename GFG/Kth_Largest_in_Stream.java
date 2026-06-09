import java.util.*;

// Using PriorityQueue (klogk)
class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }

            if (pq.size() < k) {
                ans.add(-1);
            } else {
                ans.add(pq.peek());
            }
        }

        return ans;
    }
}