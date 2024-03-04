import java.util.*;

public class sum_of_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        int sum = 0;
        int i=0;
        while (i <= a) {
            sum+=i;
            i++;
        }
        System.out.print("Sum: "+sum);
    }
}
