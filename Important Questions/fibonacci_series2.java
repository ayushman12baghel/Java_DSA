import java.util.*;

public class fibonacci_series2 {
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int first = 0, second = 1;
        int next;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }
}
