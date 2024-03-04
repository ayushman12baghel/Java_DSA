import java.util.*;

public class find_product {
    public static int product_variable(int a, int b) {
        int product = a * b;
        return product;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        int product = product_variable(a, b);
        System.out.print("The product is: " + product);

    }
}
