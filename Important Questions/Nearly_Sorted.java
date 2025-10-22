import java.util.*;

//O(nlogk)
class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        int i;

        for (i = k; i < n; i++) {
            pq.offer(arr[i]);
            arr[i - k] = pq.poll();
        }

        while (!pq.isEmpty()) {
            arr[i - k] = pq.poll();
            i++;
        }

        return;
    }
}
