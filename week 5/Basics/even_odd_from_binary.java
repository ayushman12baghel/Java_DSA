import java.util.*;
public class even_odd_from_binary {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        if((a&1)==0){
            System.out.println("The number is Even");
        }
        else{
            System.out.println("The number is odd");
        }
    }
}
