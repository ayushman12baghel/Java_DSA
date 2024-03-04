import java.util.*;

public class decimal_to_binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        dectobin(a);
    }

    public static void dectobin(int a) {
        int binary = 0;
        int pow = 0;
        while (a > 0) {
            int rem = a % 2;
            binary += rem * (Math.pow(10, pow));
            pow++;
            a /= 2;
        }
        System.out.print("The Binary of number is: " + binary);
    }
}
