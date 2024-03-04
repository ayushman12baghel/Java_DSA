import java.util.*;
public class palindrome {
    public static void check_palindrome(int a){
        int rev=0;
        int b=a;
        while (a>0){
            int lastDigit=a%10;
            rev+=lastDigit;
            rev*=10;
            a/=10;
        }
        rev/=10;
        System.out.println(rev);
        if(b==rev){
            System.out.print("The number is palindrome.");
        }
        else{
            System.out.print("The number is not palindrome");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        check_palindrome(a);
    }
}
