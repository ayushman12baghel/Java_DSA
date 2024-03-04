import java.util.*;
public class pass_fail {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your marks: ");
        int marks=sc.nextInt();
        String a=(marks>=33)?"pass":"fail";
        System.out.print(a);
    }  
}
