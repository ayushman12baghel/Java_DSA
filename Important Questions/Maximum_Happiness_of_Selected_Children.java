import java.util.*;

// Approach 1 Using PriorityQueue O(nlogn)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : happiness) {
            pq.offer(num);
        }

        int decrement = 0;
        long ans = 0;

        while (!pq.isEmpty() && k-- > 0) {
            int current = pq.poll();
            if (current - decrement <= 0) {
                break;
            }
            ans += current - decrement;
            decrement++;
        }

        return ans;
    }
}

// Approach 2 Using Sorting O(nlogn)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);
        int decrement = 0;
        long ans = 0;

        for (int i = n - 1; i >= 0 && k > 0; i--, k--) {
            if (happiness[i] - decrement <= 0) {
                break;
            }

            ans += (happiness[i] - decrement);
            decrement++;
        }

        return ans;
    }
}