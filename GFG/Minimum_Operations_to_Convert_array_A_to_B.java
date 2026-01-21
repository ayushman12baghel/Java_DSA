import java.util.*;

// Approach 1 Using LCS Code O(n*m) T.L.E
class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        int n = A.length;
        int m = B.length;

        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int lcs = solve(A, B, 0, 0, dp);

        return n + m - 2 * lcs;
    }

    static int solve(int nums1[], int nums2[], int i, int j, int dp[][]) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + solve(nums1, nums2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(nums1, nums2, i + 1, j, dp), solve(nums1, nums2, i, j + 1, dp));
        }
    }
};

// Approach 2 Using LIS Code O(nlogn)
class Solution {
    static int minInsAndDel(int[] nums1, int[] nums2, int N, int M) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums2) {
            set.add(num);
        }

        List<Integer> validA = new ArrayList<>();
        for (int num : nums1) {
            if (set.contains(num)) {
                validA.add(num);
            }
        }

        int LISLength = solve(validA);

        return (N - LISLength) + (M - LISLength);
    }

    public static int solve(List<Integer> nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int maxLength = 0;

        for (int i = 0; i < nums.size(); i++) {
            int length = 1;

            Integer key = map.lowerKey(nums.get(i));
            if (key != null) {
                length += map.get(key);
            }

            maxLength = Math.max(maxLength, length);
            map.put(nums.get(i), length);

            key = map.higherKey(nums.get(i));

            while (key != null && map.get(key) <= length) {
                map.remove(key);
                key = map.higherKey(nums.get(i));
            }
        }

        return maxLength;
    }
};