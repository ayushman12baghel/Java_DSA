import java.util.*;

public class hollow_rectangle_pattern {
    public static void rectangle(int a, int b) {
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= a; j++) {
                if (i == 1 || i == b || j == 1 || j == a) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        int a = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int b = sc.nextInt();
        rectangle(a, b);
    }
}
