import java.util.*;
public class diamond_pattern {
    public static void diamond(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=a-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            // for(int j=1;j<=a-i;j++){
            //     System.out.print(" ");
            // }
            System.out.println();
        }
        for(int i=a;i>=1;i--){
            for(int j=1;j<=a-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            // for(int j=1;j<=a-i;j++){
            //     System.out.print(" ");
            // }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        diamond(a);
    }
}
