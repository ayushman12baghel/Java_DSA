import java.util.*;
public class calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a=sc.nextInt();
        System.out.print("Enter second number: ");
        int b=sc.nextInt();
        System.out.print("Enter the operation: ");
        String c=sc.next();
        switch(c){
            case "+":System.out.print(a+b);
            break;
            case "-":System.out.print(a-b);
            break;
            case "*":System.out.print(a*b);
            break;
            case "/":System.out.print(a/b);
            break;
            default: System.out.print("Wrong Operator");
        }
    }
}
