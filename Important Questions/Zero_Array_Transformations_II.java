public class Zero_Array_Transformations_II {

    // Trying Brute Force O(Q*n)
    public static int minZeroArray(int[] nums, int[][] queries) {
        int nonZero = 0;
        int k = 0;
        for (int num : nums) {
            if (num > 0) {
                nonZero++;
            }
        }

        if (nonZero == 0) {
            return k;
        }

        for (int query[] : queries) {
            k++;
            int left = query[0];
            int right = query[1];
            int value = query[2];

            for (int i = left; i <= right; i++) {
                if (nums[i] != 0) {
                    if (value >= nums[i]) {
                        nonZero--;
                        nums[i] = 0;
                    } else {
                        nums[i] -= value;
                    }
                }
            }

            if (nonZero == 0) {
                return k;
            }
        }

        return nonZero != 0 ? -1 : k;
    }

    // Approach 2 Using Difference Array Technique O(Q*n)
    public static int minZeroArray2(int nums[], int queries[][]) {
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }

        if (zeroCount == nums.length) {
            return 0;
        }

        int diff[] = new int[nums.length + 1];

        for (int i = 0; i < queries.length; i++) {
            if (checkWithDiffernceArray(nums, queries, i, diff)) {
                return i + 1;
            }
        }

        return -1;
    }

    public static boolean checkWithDiffernceArray(int nums[], int queries[][], int index, int diff[]) {
        int left = queries[index][0];
        int right = queries[index][1];
        int value = queries[index][2];

        diff[left] += value;
        if (right + 1 < nums.length) {
            diff[right + 1] -= value;
        }

        int cumSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumSum += diff[i];

            if (nums[i] - cumSum > 0) {
                return false;
            }
        }

        return true;
    }

    // Approach 3 Using Difference Array Technique With Binary Search
    // O((Q+n)*log(Q))
    public static int minZeroArray3(int[] nums, int[][] queries) {
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }

        if (zeroCount == nums.length) {
            return 0;
        }

        int left = 0;
        int right = queries.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkWithDifferenceArray1(nums, queries, mid)) {
                ans = mid + 1;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean checkWithDifferenceArray1(int nums[], int queries[][], int k) {
        int diff[] = new int[nums.length];

        for (int i = 0; i <= k; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];

            diff[left] += value;
            if (right + 1 < nums.length) {
                diff[right + 1] -= value;
            }
        }

        int cumSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumSum += diff[i];

            if (nums[i] - cumSum > 0) {
                return false;
            }
        }

        return true;
    }

    // Differnce Array Similar to applied in Zero Array Tranf I
    public static boolean checkWithDifferenceArray2(int nums[], int queries[][], int index) {
        int diff[] = new int[nums.length];

        for (int i = 0; i <= index; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];

            diff[left] -= val;

            if (right + 1 < nums.length) {
                diff[right + 1] += val;
            }
        }

        int cumSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumSum += diff[i];

            if (nums[i] + cumSum > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 0, 2 };
        int queries[][] = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        // System.out.println(minZeroArray(nums, queries));
        System.out.println(minZeroArray2(nums, queries));
        System.out.println(minZeroArray3(nums, queries));
    }
}
