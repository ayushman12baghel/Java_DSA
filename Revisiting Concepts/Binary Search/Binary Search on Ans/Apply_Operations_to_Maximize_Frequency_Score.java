import java.util.Arrays;

public class Apply_Operations_to_Maximize_Frequency_Score {

    // Approach Binary Search On Ans + Sorting O(n*logn)
    public static int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums.length;
        int result = 1;

        long prefixSum[] = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, k, prefixSum)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int size, long k, long prefixSum[]) {
        int i = 0;
        int j = size - 1;

        while (j < nums.length) {
            int targetIndex = (i + j) / 2;
            long target = nums[targetIndex];

            long operationsLeft;
            long operationsRight;

            if (targetIndex == 0) {
                operationsLeft = 0;
            } else {
                operationsLeft = Math.abs(
                        ((targetIndex - i) * target - (prefixSum[targetIndex - 1] - (i > 0 ? prefixSum[i - 1] : 0))));
            }

            operationsRight = Math.abs(((j - targetIndex) * target) - (prefixSum[j] - prefixSum[targetIndex]));

            if (operationsLeft + operationsRight <= k) {
                return true;
            }

            i++;
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 6, 4 };
        int k = 3;

        System.out.println(maxFrequencyScore(nums, k));
    }
}
