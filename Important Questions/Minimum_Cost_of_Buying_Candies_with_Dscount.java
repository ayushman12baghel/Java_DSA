import java.util.*;

// Approach 1 Using PriorityQueue O(nlogn)
class Solution {
    public int minimumCost(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int totalCost = 0;

        for (int num : nums) {
            pq.offer(num);
            totalCost += num;
        }

        if (nums.length <= 2) {
            return totalCost;
        }

        while (pq.size() > 2) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            totalCost -= pq.poll();
        }

        return totalCost;
    }
}

// Approch 2 Greedy Sorting O(nlogn)
class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            if ((n - 1 - i) % 3 != 2) {
                ans += nums[i];
            }
        }

        return ans;
    }
}