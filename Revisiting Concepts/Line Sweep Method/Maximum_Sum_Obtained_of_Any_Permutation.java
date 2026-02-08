import java.util.*;

//Approach 1 Using Difference Array and Sorting O(nlogn)
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = 1000000007;

        int maxFreq[] = new int[n + 2];
        for (int request[] : requests) {
            int left = request[0];
            int right = request[1];

            maxFreq[left]++;
            maxFreq[right + 1]--;
        }

        int currSum = 0;
        for (int i = 0; i < maxFreq.length; i++) {
            currSum += maxFreq[i];
            maxFreq[i] = currSum;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        Arrays.sort(nums);
        for (int num : maxFreq) {
            if (num > 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int i = n - 1;
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getKey();
            int count = entry.getValue();

            while (count-- > 0 && i >= 0) {
                ans = (ans + 1L * freq * nums[i]) % mod;
                i--;
            }
        }

        return (int) (ans % mod);
    }
}

// Approach 2 Same but more Optimised O(nlogn)
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = 1000000007;

        int maxFreq[] = new int[n];
        for (int request[] : requests) {
            int left = request[0];
            int right = request[1];

            maxFreq[left]++;
            if (right + 1 < n) {
                maxFreq[right + 1]--;
            }
        }

        int currSum = 0;
        for (int i = 0; i < maxFreq.length; i++) {
            currSum += maxFreq[i];
            maxFreq[i] = currSum;
        }

        Arrays.sort(nums);
        Arrays.sort(maxFreq);
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            long contrib = 1L * nums[i] * maxFreq[i];
            ans = (ans + contrib) % mod;
        }

        return (int) (ans % mod);
    }
}