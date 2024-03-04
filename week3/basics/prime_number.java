import java.util.*;

public class prime_number {
    public static void check_prime(int a) {
        int b = 0;
        for (int i = 2; i <= a - 1; i++) {
            if (a % i == 0) {
                b += 1;
                break;
            } else {
                b = 0;
            }
        }
        if (b == 0) {
            System.out.print("The number is prime");
        } else {
            System.out.print("The number is composite");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        check_prime(a);
    }
}
