public class Missing_Number {

    // O(n) SC= O(1)
    public static int missingNumber(int nums[]) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 1, 3 };

        System.out.println(missingNumber(nums));
    }
}
