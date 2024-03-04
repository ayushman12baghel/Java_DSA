import java.util.*;
public class factorial {
    public static int factorial(int a){
        if(a==1 || a==0){
            return 1;
        }
        return a*factorial(a-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        System.out.println(factorial(a));
    }
}
