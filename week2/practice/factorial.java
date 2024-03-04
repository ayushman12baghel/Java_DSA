import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        int sum=01;
        if (a==1|| a==0){
            System.out.print("The factorial is: "+sum);
        }
        else{
            for(int i=1;i<=a;i++){
                sum*=i;
            }
            System.out.println("The factorial is: "+sum);
        }
    }
}
