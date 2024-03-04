import java.util.*;

public class leap_year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int a = sc.nextInt();
        if (a % 4 == 0 && (a % 400 == 0 || a % 100 != 0)) {
            System.out.print("Leap year");
        } else {
            System.out.print("Not a leap year");
        }
    }
}
