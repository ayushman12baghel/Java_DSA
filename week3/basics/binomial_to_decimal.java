import java.util.*;
public class binomial_to_decimal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Binary number: ");
        int a=sc.nextInt();
        int decimal=0;
        int pow=0;
        while(a>0){
            int lastDigit=a%10;
            a/=10;
            decimal+=lastDigit*(Math.pow(2, pow));
            pow++;
        }System.out.print("The Decimal of Binary is: "+decimal);
    }
}
