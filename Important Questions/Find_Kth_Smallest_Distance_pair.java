import java.util.Arrays;

public class Find_Kth_Smallest_Distance_pair {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        int result = 0;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = slidingWindowCount(nums, mid);
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int slidingWindowCount(int nums[], int mid) {
        int j = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1;
        }

        return count;
    }

    public static int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] - nums[0];
        int arr[] = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                arr[d]++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            k -= arr[i];
            if (k <= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 1 };
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
        System.out.println(smallestDistancePair2(nums, k));

    }
}
