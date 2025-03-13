public class Zero_Array_Transformations_I {

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n + 1];

        for (int query[] : queries) {
            int left = query[0];
            int right = query[1];

            diff[left]--;

            if (right + 1 < n) {
                diff[right + 1]++;
            }
        }

        int cumSum = 0;

        for (int i = 0; i < n; i++) {
            cumSum += diff[i];

            nums[i] += cumSum;

            if (nums[i] > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 0, 1 };
        int queries[][] = { { 0, 2 } };
        System.out.println(isZeroArray(nums, queries));
    }
}
