import java.util.*;
public class sum_of_natural_no {
    public static int sum(int a){
        if(a==1 || a==0){
            return 1;
        }
        return a+sum(a-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        System.out.println(sum(a));
    }
}
