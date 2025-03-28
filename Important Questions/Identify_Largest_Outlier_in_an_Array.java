import java.util.*;

public class Identify_Largest_Outlier_in_an_Array {

    public static int getLargestOutlier(int nums[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalSum = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            totalSum += num;
        }

        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            int outlier = num;
            map.put(outlier, map.get(outlier) - 1);

            int remainingSum = totalSum - outlier;

            if (remainingSum % 2 == 0) {
                remainingSum /= 2;

                if (map.containsKey(remainingSum) && map.get(remainingSum) > 0) {
                    ans = Math.max(outlier, ans);
                }
            }

            map.put(outlier, map.getOrDefault(outlier, 0) + 1);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 3, 5, 10 };

        System.out.println(getLargestOutlier(nums));
    }
}
