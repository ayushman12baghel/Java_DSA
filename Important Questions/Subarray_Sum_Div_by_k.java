import java.util.*;

public class Subarray_Sum_Div_by_k {

    // Using Brute Force O(n^2)
    public static int subarraysDivByK2(int[] nums, int k) {
        int count = 0;
        int prefixSum[] = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = (i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1]);

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarrayDivByK(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 4, 5, 0, -2, -3, 1 };
        int k = 5;

        System.out.println(subarrayDivByK(nums, k));
    }
}
