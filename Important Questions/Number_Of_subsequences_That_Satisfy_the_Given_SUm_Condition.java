import java.util.Arrays;

public class Number_Of_subsequences_That_Satisfy_the_Given_SUm_Condition {

    // Approach 1 Sorting and Calculation Combinations
    public static int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + findPower(mod, right - left)) % mod;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static int findPower(int mod, int exp) {
        int base = 2;
        int result = 1;

        while (exp > 0) {
            if (exp % 2 != 0) {
                result = (int) (((long) result * base) % mod);
            }

            base = (int) (((long) base * base) % mod);
            exp /= 2;
        }

        return (int) result;
    }

    // Approach 2 Using PreComputed Power
    public static int numSubseq2(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        int pow[] = new int[nums.length + 1];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 5, 6, 7 };
        int target = 9;

        System.out.println(numSubseq(nums, target));
        System.out.println(numSubseq2(nums, target));
    }
}
