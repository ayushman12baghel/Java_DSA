import java.util.*;
public class fibonacci_series {
    public static int fib(int a){
        if(a==1){
            return 1;
        }
        if(a==0){
            return 0;
        }
        int n_1=fib(a-1);
        int n_2=fib(a-2);
        int n=n_1+n_2;
        return n;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        System.out.println(fib(a));
    }
}
