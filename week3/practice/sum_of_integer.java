import java.util.*;
public class sum_of_integer {
    public static void sum_of_integer(int a){
        int sum=0;
        while(a>0){
            int last_digit=a%10;
            sum+=last_digit;
            a/=10;
        }
        System.out.print("The sum of the integers is: "+sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        sum_of_integer(a);
    }
}
