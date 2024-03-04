import java.util.*;

public class keep_entering_numbers_till_mul_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        while (true) {
            if (a % 10 == 0) {
                System.out.println("You entered multiple of 10");
                break;
            } else {
                System.out.println(a);
                System.out.print("Enter the number: ");
                a = sc.nextInt();
            }
        }
    }

}
