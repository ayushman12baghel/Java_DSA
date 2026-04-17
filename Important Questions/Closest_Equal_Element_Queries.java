import java.util.*;

//Approach 1 Using Binary Search O(nlogn)
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int query : queries) {
            int targetValue = nums[query];
            List<Integer> list = map.get(nums[query]);
            int m = list.size();

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int index = binarySearch(list, query);
            int left = list.get((index - 1 + m) % m);
            int right = list.get((index + 1) % m);

            int leftDist = Math.min(Math.abs(query - left), n - Math.abs(query - left));
            int rightDist = Math.min(Math.abs(query - right), n - Math.abs(query - right));

            ans.add(Math.min(leftDist, rightDist));
        }

        return ans;
    }

    public int binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

// Approach 2 O(n+m)
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist[] = new int[n];
        Arrays.fill(minDist, -1);

        for (List<Integer> list : map.values()) {
            int m = list.size();

            if (m == 1) {
                continue;
            }

            for (int index = 0; index < m; index++) {
                int curr = list.get(index);

                int left = list.get((index - 1 + m) % m);
                int right = list.get((index + 1) % m);

                int leftDist = Math.min(Math.abs(curr - left), n - Math.abs(curr - left));
                int rightDist = Math.min(Math.abs(curr - right), n - Math.abs(curr - right));

                minDist[curr] = Math.min(leftDist, rightDist);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            ans.add(minDist[query]);
        }

        return ans;
    }
}