
import java.util.*;
public class palindrome_pattern {
    public static void palindrome_pattern(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=a-i;j++){
                System.out.print(" ");
            }
            if(i==1){
                System.out.print(i);
            }
            else{
                for(int j=1;j<=(2*i-1)/2;j++){
                    int b=i;
                    System.out.print(b);
                    b--; 
                }  
                for(int k=1;k<=(2*i-1)/2;k++){
                    int b=2;
                    System.out.print(b);   
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        palindrome_pattern(a);
    }    
}
