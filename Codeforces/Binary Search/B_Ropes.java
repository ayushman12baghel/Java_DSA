import java.util.*;

public class B_Ropes {

    public static boolean isPossible(int nums[], double mid, int k) {
        long pieces = 0;

        for (int num : nums) {
            pieces += (int) num / mid;
        }

        return pieces >= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int nums[] = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }

        double left = 0;
        double right = max;
        double ans = left;

        while (right - left > 1e-7) {
            double mid = (left + right) / 2.0;
            ;

            if (isPossible(nums, mid, k)) {
                ans = mid;
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(ans);
    }
}