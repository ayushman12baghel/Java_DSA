import java.util.*;

public class Divisible_and_not_Divisible_Sums_Difference {

    // Approach 1 Using Brute Force
    public static int differenceOfSums(int n, int m) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sum2 += i;
            } else {
                sum1 += i;
            }
        }

        return sum1 - sum2;
    }

    // Approach 2 Using Formula T.C -> O(1)
    public static int differenceOfSums2(int n, int m) {
        int k = n / m;
        int num2 = m * (k * (k + 1) / 2);
        int total = n * (n + 1) / 2;
        int num1 = total - num2;

        return num1 - num2;
    }

    public static void main(String args[]) {
        int n = 10, m = 3;

        System.out.println(differenceOfSums(n, m));
        System.out.println(differenceOfSums2(n, m));
    }
}
