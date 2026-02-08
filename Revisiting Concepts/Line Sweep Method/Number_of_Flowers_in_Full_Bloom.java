import java.util.*;

//Approach 1 Using LineSweep Method O(nlogn + O(mlogn))
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int flower[] : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }

        int currSum = 0;
        for (Integer key : map.keySet()) {
            currSum += map.get(key);
            map.put(key, currSum);
        }

        int ans[] = new int[people.length];
        for (int i = 0; i < ans.length; i++) {
            if (map.containsKey(people[i])) {
                ans[i] = map.get(people[i]);
            } else {
                Integer prev = map.floorKey(people[i]);
                if (prev != null) {
                    ans[i] = map.get(prev);
                }
            }
        }

        return ans;
    }
}

// Approach 2 Using BinarySearch and Sorting O(nlogn)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int m = people.length;

        int start[] = new int[n];
        int end[] = new int[n];
        int ans[] = new int[m];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0; i < m; i++) {
            ans[i] = binarySearchEqual(start, people[i]) - binarySearchSmaller(end, people[i]);
        }

        return ans;
    }

    public int binarySearchEqual(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int binarySearchSmaller(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}