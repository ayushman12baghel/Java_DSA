import java.util.*;

public class display_all_numbers_Except_mul_of_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        for(int i=1;i<=a;i++){
            if(i%10==0){
                continue;
            }
            else{
                System.out.println(i);
            }
        }
    }

}

