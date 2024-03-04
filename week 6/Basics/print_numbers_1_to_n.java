import java.util.*;
public class print_numbers_1_to_n {
    public static void increasingNumbers(int a){
        if(a==1){
            System.out.println(a);
            return;
        }
        increasingNumbers(a-1);
        System.out.println(a);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        increasingNumbers(a);
    }
}
