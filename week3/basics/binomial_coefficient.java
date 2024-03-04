import java.util.*;

public class binomial_coefficient {
    public static int fact(int a) {
        if (a <= 1) {
            return 1;
        } else {
            return a * fact(a - 1);
        }
    }

    public static void binCoeff(int a, int b) {
        int n_fact = fact(a);
        int r_fact = fact(b);
        int nr_fact = fact(a - b);
        System.out.print("The Binomial Coefficient is: " + n_fact / (r_fact * nr_fact));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n: ");
        int a = sc.nextInt();
        System.out.print("Enter the r: ");
        int b = sc.nextInt();
        binCoeff(a, b);
    }
}
