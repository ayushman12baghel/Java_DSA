import java.util.*;
public class hollow_rhombus {
    public static void rhombus(int a){
        for(int i=1;i<=a;i++){
            for(int j=0;j<=a-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=a;j++){
                if(i==1 || j==1 || i==a || j==a){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size: ");
        int a=sc.nextInt();
        rhombus(a);
    }
}
