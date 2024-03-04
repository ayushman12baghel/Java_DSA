import java.util.*;
public class reverse_number_in_variable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        int rev=0;
        while(a>0){
            int lastDigit=a%10;
            rev=(rev*10)+lastDigit;
            a/=10;
        }
        System.out.println(rev);
    }
}