import java.util.*;
public class hollow_rhombus_pattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length: ");
        int a=sc.nextInt();
        for(int i=1;i<=a;i++){
            for(int j=1;j<=a-i+1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=1;j++){
                if(i==1 || i==a || j==1 ||j==a){
                    System.out.print("*".repeat(a));
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
