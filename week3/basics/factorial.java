import java.util.*;

public class factorial {
    public static void factors(int a) {
        int fact_sum = 1;
        if (a >= 0) {

            for (int i = 1; i <= a; i++) {
                fact_sum *= i;
            }
            System.out.print("The Factorial is: " + fact_sum);
        } else {
            System.out.print("Enter the positive number");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        factors(a);
    }
}
