import java.util.*;

public class A_Segment_with_Small_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = sc.nextLong();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxLength = 0;
        long currentSum = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            currentSum += nums[j];

            while (currentSum > sum) {
                currentSum -= nums[i];
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        System.out.println(maxLength);
    }
}