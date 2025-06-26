import java.util.*;

public class D_Number_of_Segments_with_Big_Sum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = sc.nextLong();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long currentSum = 0;
        long ans = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            currentSum += nums[j];

            while (currentSum >= sum) {
                ans += (n - j);
                currentSum -= nums[i];
                i++;
            }

            j++;
        }

        System.out.println(ans);
    }
}