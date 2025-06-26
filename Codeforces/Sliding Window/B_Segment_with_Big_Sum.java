import java.util.*;

public class B_Segment_with_Big_Sum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = sc.nextLong();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long currentSum = 0;
        int minLength = n + 1;
        int i = 0;
        int j = 0;

        while (j < n) {
            currentSum += nums[j];

            while (currentSum >= sum) {
                currentSum -= nums[i];
                minLength = Math.min(minLength, j - i + 1);
                i++;
            }
            j++;
        }
        minLength = (minLength == n + 1 ? -1 : minLength);

        System.out.println(minLength);
    }
}