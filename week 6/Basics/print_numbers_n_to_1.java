import java.util.*;
public class print_numbers_n_to_1 {
    public static int decreasingNumber(int a){
        if(a<=1){
            return 1;
        }
        System.out.println(a);
        return  (decreasingNumber(a-1));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        System.out.println(decreasingNumber(a));
    }
}
