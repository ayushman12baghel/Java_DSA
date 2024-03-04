import java.util.*;
public class largest_of_3_numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a=sc.nextInt();
        System.out.print("Enter the second number: ");
        int b=sc.nextInt();
        System.out.print("Enter the third number: ");
        int c=sc.nextInt();
        if(a<b && c<b){
            System.out.print("The second number is greatest");
        }
        else if(a>b && a>c){
            System.out.print("The first number is greatest");
        }
        else{
            System.out.print("The third number is greatest");
        }
    }  
}

