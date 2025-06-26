import java.util.*;

public class C_Number_of_Segments_with_Small_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = sc.nextLong();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long ans = 0;
        int i = 0;
        int j = 0;
        long currentSum = 0;

        while (j < n) {
            currentSum += nums[j];

            while (currentSum > sum) {
                currentSum -= nums[i];
                i++;
            }

            ans += (j - i + 1);
            j++;
        }

        System.out.println(ans);
    }
}