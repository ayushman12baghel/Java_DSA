import java.util.*;
public class number_pyramid_pattern {
    public static void pyramid(int a){
        for(int i=0;i<=a;i++){
            for(int j=1;j<=a-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                if(j%2==0){
                    System.out.print(" ");
                }
                else{
                    System.out.print(i);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the height: ");
        int a=sc.nextInt();
        pyramid(a);
    }
}
