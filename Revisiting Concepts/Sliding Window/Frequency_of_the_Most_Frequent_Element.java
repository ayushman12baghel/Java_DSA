import java.util.*;

public class Frequency_of_the_Most_Frequent_Element {

    // Approach 1 Using prefixSum O(nlogn)
    public static int maxFrequency(int nums[], int k) {
        int n = nums.length;
        Arrays.sort(nums);

        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, binarySearch(nums, k, i, prefixSum));
        }

        return ans;
    }

    public static int binarySearch(int nums[], int k, int targetIndex, long prefixSum[]) {
        int left = 0;
        int right = targetIndex;
        int result = targetIndex;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int count = targetIndex - mid + 1;
            long windowSum = count * nums[targetIndex];
            long currentSum = prefixSum[targetIndex] - prefixSum[mid] + nums[mid];

            int ops = (int) (windowSum - currentSum);

            if (ops > k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return targetIndex - result + 1;
    }

    // Approach 2 Using Sliding Window and Sorting
    public static int maxFrequency2(int nums[], int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxLength = 0;
        long currentSum = 0;

        while (j < n) {
            currentSum += nums[j];
            int target = nums[j];

            while ((long) (j - i + 1) * target - currentSum > k) {
                currentSum -= nums[i];
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 4 };
        int k = 5;

        System.out.println(maxFrequency(nums, k));
        System.out.println(maxFrequency2(nums, k));
    }
}
