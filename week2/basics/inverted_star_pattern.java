import java.util.*;
public class inverted_star_pattern {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        for (int i=1;i<=a;i++){
            for (int j=1;j<=a-i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
