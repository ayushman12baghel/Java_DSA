import java.util.*;

public class G_Student_Councils {

    public static boolean isPossible(int nums[], long mid, int k) {
        long count = 0;

        for (int num : nums) {
            count += Math.min(num, mid);
        }

        return count >= mid * k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int nums[] = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        long left = 1;
        long right = sum / k;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(nums, mid, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}