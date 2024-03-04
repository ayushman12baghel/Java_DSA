import java.util.*;

public class _0_1_triangle_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        int x = 1;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                if (x % 2 == 0) {
                    System.out.print(0 + " ");
                    x++;
                } else {
                    System.out.print(1 + " ");
                    x++;
                }
            }
            System.out.println();
        }
    }
}
