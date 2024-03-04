import java.util.*;
public class even_odd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        if(a%2==0){
            System.out.print("The number is even");
        }
        else{
            System.out.print("The number is odd");
        }
    }  
}
