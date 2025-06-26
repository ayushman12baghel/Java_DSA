import java.util.*;

public class A_Binary_Search {

    public static boolean check(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int nums[] = new int[n];
        int nums2[] = new int[m];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if (check(nums, nums2[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}