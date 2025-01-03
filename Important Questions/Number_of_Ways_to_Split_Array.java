public class Number_of_Ways_to_Split_Array {

    public static int waysToSplitArray(int nums[]) {
        int ans = 0;
        long sum = 0;
        int n = nums.length;
        long prefixSum[] = new long[n];

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        for (int i = 0; i < n - 1; i++) {
            if (prefixSum[i] >= (prefixSum[n - 1] - prefixSum[i])) {
                ans++;
            }
        }

        return ans;
    }

    // More Optimised

    public static int waysToSplitArray2(int nums[]) {
        long total = 0;
        long left = 0;
        int ans = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            if (left >= (total - left)) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 10, 4, -8, 7 };

        System.out.println(waysToSplitArray(nums));

        System.out.println(waysToSplitArray2(nums));
    }
}
