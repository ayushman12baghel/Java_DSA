import java.util.HashMap;

public class Subarray_With_Given_Xor {

    // Using HashMap
    public static int solve(int[] nums, int k) {
        int n = nums.length;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];

            int target = xor ^ k;
            count += map.getOrDefault(target, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(solve(nums, k));
    }
}
