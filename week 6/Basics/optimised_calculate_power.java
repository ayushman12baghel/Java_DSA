import java.util.*;
public class optimised_calculate_power {
    public static int calculatePower(int base, int pow){
        if(pow==0){
            return 1;
        }
        else{
            int temp=calculatePower(base, pow/2);
            if(pow%2==0){
                return temp*temp;
            }
            else{
                return base*temp*temp;
            }
        }
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
