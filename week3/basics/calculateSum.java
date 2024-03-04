import java.util.*;

public class calculateSum {
    public static int calculateSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the first number: ");
        int b = sc.nextInt();
        int sum = calculateSum(a, b);
        System.out.print("sum: " + sum);
    }
}
