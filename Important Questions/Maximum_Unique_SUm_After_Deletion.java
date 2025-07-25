import java.util.HashSet;
import java.util.Set;

public class Maximum_Unique_SUm_After_Deletion {

    public static int maxSum(int[] nums) {
        boolean hasPositive = false;
        int maxSum = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            maxSum = Math.max(maxSum, num);

            if (num >= 0) {
                set.add(num);
                hasPositive = true;
            }
        }

        if (!hasPositive) {
            return maxSum;
        }

        int ans = 0;
        for (int num : set) {
            ans += num;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1 };

        System.out.println(maxSum(nums));
    }
}
