import java.util.*;

public class find_even {
    public static boolean check_even(int a) {
        if (a % 2 != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        if (check_even(a)) {
            System.out.print("The number is even");
        } else {
            System.out.print("The nimber is odd");
        }
    }
}
