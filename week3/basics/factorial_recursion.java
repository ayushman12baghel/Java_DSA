import java.util.*;

public class factorial_recursion {
    public static int fact(int a) {
        if (a <= 1)
        return 1;
    else    
        return a*fact(a-1); 
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        int factorial=fact(a);
        System.out.print("The factorial is: "+factorial);
    }
}
