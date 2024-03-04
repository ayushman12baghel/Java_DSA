
import java.util.*;

public class fever_or_not {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temperature in f: ");
        int a=sc.nextInt();
        if(a>100){
            System.out.print("You have fever");
        }
        else{
            System.out.print("You don't have fever" );
        }
    }
}
