public class Shortest_subarray_with_or_at_least_k_II {

    // not optimised failed 2 test cases
    public static int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int maxOr = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            maxOr |= nums[right];

            while (maxOr >= k && left <= right) {
                ans = Math.min(ans, right - left + 1);
                left++;
                maxOr = 0;
                for (int i = left; i <= right; i++) {
                    maxOr |= nums[i];
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int minimumSubarrayLength2(int nums[], int k) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int bits[] = new int[32];

        while (right < nums.length) {
            update(nums[right], bits, 1);
            while (left <= right && getDecimal(bits) >= k) {
                ans = Math.min(ans, right - left + 1);
                update(nums[left], bits, -1);
                left++;
            }
            right++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void update(int num, int bits[], int key) {
        for (int i = 0; i < 32; i++) {
            if ((num >> i & 1) == 1) {
                bits[i] += key;
            }
        }
    }

    public static int getDecimal(int bits[]) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) {
                num |= (1 << i);
            }
        }
        return num;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 1, 8 };
        int k = 10;

        System.out.println(minimumSubarrayLength(nums, k));
        System.out.println(minimumSubarrayLength2(nums, k));
    }
}
