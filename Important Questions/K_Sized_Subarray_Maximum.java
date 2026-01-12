import java.util.*;

//Approach Using TreeMap O(nlogk)
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 >= k) {
                ans.add(map.lastKey());
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return ans;
    }
}

// Approach 2 Using Deque O(n)
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;

        while (j < n) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }

            deque.addLast(j);

            while (!deque.isEmpty() && deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }

            if (j >= k - 1) {
                ans.add(nums[deque.peekFirst()]);
            }

            j++;
        }

        return ans;
    }
}