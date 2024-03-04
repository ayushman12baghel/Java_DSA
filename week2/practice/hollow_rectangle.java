import java.util.*;
public class hollow_rectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Length: ");
        int a=sc.nextInt();
        System.out.print("Enter Breadth: ");
        int b=sc.nextInt();
        for(int i=1;i<=b;i++){
            for (int j=1;j<=a;j++){
                if (j==1|| i==1 || j==a || i==b){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
