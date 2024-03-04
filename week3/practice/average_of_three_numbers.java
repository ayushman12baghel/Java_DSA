
import java.util.*;

public class average_of_three_numbers {
    public static void average_(int a, int b, int c) {
        int average = (a + b + c) / 3;
        System.out.print("The average is: " + average);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        System.out.print("Enter the three number: ");
        int c = sc.nextInt();
        average_(a, b, c);
    }
}
