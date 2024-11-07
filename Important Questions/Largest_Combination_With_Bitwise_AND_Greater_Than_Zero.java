public class Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {

    public static int largestCombination(int nums[]) {
        int maxCount = 0;

        for (int bitpos = 0; bitpos < 32; bitpos++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << bitpos)) != 0) {
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    // more optimised
    public static int largestCombination2(int[] candidates) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candidates.length; i++) {
            max = Math.max(max, candidates[i]);
        }
        int m = Integer.SIZE - Integer.numberOfLeadingZeros(max);
        int maxCount = 0;

        for (int bitpos = 0; bitpos < m; bitpos++) {
            int count = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << bitpos)) != 0) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int nums[] = { 16, 17, 71, 62, 12, 24, 14 };

        System.out.println(largestCombination(nums));
        System.out.println(largestCombination2(nums));
    }
}
