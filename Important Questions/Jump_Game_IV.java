import java.util.*;

// Approach Using BFS and HashMap O(n)
class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean visited[] = new boolean[n];
        visited[0] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n - 1) {
                    return count;
                }

                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }
                if (current + 1 < n && !visited[current + 1]) {
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }

                if (map.containsKey(nums[current])) {
                    for (int index : map.get(nums[current])) {
                        if (!visited[index]) {
                            visited[index] = true;
                            queue.offer(index);
                        }
                    }

                    map.remove(nums[current]);
                }
            }

            count++;
        }

        return -1;
    }
}