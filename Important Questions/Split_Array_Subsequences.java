import java.util.*;

class Solution {

    static boolean isPossible(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int i = 0;
        while (i < arr.length) {
            if (pq.isEmpty()) {
                pq.add(new int[] { arr[i], 1 });
                i++;
            } else {
                int[] top = pq.peek();
                if (arr[i] == top[0]) {
                    pq.add(new int[] { arr[i], 1 });
                    i++;
                } else if (arr[i] == top[0] + 1) {
                    pq.poll();
                    pq.add(new int[] { arr[i], top[1] + 1 });
                    i++;
                } else {
                    if (top[1] < k)
                        return false;
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) {
            if (pq.peek()[1] < k)
                return false;
            pq.poll();
        }

        return true;
    }

}