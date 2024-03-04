import java.util.*;
public class inverted_rotated_half_pyramid {
    public static void pyramid(int a){
        for(int i=1;i<=a;i++){
            for( int j=1;j<=a-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
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
