import java.util.*;

public class print_prime_in_range {
    public static boolean check_prime(int a) {
        if (a == 2) {
            return true;
        }
        for (int i = 2; i <= a - 1; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void print_prime(int a) {
        System.out.print("The prime numbers are: ");
        for (int i = 2; i <= a; i++) {
            if (check_prime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        print_prime(a);
    }
}
