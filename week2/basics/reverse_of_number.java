import java.util.*;
public class reverse_of_number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        while(a>0){
            int lastDigit=a%10;
            System.out.print(lastDigit);
            a/=10;
        }
        System.out.println();
    }
}