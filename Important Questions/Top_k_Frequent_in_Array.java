import java.util.*;

//O(nlogn)
class Solution {
    public ArrayList<Integer> topKFreq(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] { entry.getKey(), entry.getValue() });
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }

        return ans;
    }
}
