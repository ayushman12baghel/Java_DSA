import java.util.*;

public class print_numbers_loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        int i = 1;
        while (i <= a) {
            System.out.println(i);
            i++;
        }
    }
}
