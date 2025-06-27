import java.util.*;

public class B_Splitting_an_Array {

    public static boolean isPossible(int nums[], long mid, int k) {
        long count = 1;
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return count <= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int nums[] = new int[n];
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            max = Math.max(nums[i], max);
        }

        long left = max;
        long right = sum;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}