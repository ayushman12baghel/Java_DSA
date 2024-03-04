import java.util.*;
public class bill_output_for_user {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the cost of pencil: ");
        int a=sc.nextInt();
        System.out.print("Enter the cost of eraser: ");
        int b=sc.nextInt();
        System.out.print("Enter the cost of sharpner: ");
        int c=sc.nextInt();
        float sum=(a+b+c)+(a+b+c)*18/100;
        System.out.print("The total price is including GST is: ");
        System.out.print(sum);
    }
}
