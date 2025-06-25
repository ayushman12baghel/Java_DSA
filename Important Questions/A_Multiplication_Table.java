import java.util.*;

public class A_Multiplication_Table {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (x % i == 0) {
                int j = x / i;
                if (j <= n) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}