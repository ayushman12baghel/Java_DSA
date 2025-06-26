import java.util.*;

public class A_Sereja_and_Dima {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum1 = 0;
        int sum2 = 0;
        int left = 0;
        int right = n - 1;
        boolean canTake = true;

        while (left <= right) {
            if (canTake) {
                if (nums[left] >= nums[right]) {
                    sum1 += nums[left];
                    left++;
                    canTake = false;
                } else {
                    sum1 += nums[right];
                    right--;
                    canTake = false;
                }
            } else {
                if (nums[left] >= nums[right]) {
                    sum2 += nums[left];
                    left++;
                    canTake = true;
                } else {
                    sum2 += nums[right];
                    right--;
                    canTake = true;
                }
            }
        }

        System.out.println(sum1 + " " + sum2);
    }
}