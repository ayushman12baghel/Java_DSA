import java.util.*;

public class Subarray_Sum_Div_by_k {

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
