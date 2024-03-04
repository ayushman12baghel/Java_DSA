import java.util.*;

public class power_function_2 {
    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int half_pow = power(a, b / 2) * power(a, b / 2);
        if (b % 2 != 0) {
            return a * half_pow;
        }
        return half_pow;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        System.out.print("Enter the power: ");
        int b = sc.nextInt();
        System.out.println(power(a, b));
    }
}