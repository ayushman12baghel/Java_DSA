import java.util.*;
public class print_power {
    public static int calculatePower(int base,int pow){
        if(pow==0){
            return 1;
        }
        // else if(pow==1){
        //     return base;
        // }
        return base*calculatePower(base, pow-1);
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the base value: ");
        int base=sc.nextInt();
        System.out.print("Enter the power: ");
        int pow=sc.nextInt();
        System.out.println(calculatePower(base,pow));
    }
}
