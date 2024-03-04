import java.util.*;

public class prime_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int a = 0;
        // for (int i = 2; i <= n - 1; i++) {
        //     if (n % i == 0) {
        //         a = 1;
        //         break;
        //     }
        // }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                a = 1;
                break;
            }
        }
        if (a == 0) {
            System.out.print("The number is prime");
        } else {
            System.out.print("The number is composite");
        }
    }
}
