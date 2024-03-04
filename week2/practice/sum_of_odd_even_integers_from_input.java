import java.util.*;

public class sum_of_odd_even_integers_from_input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        int sum_odd = 0;
        int sum_even = 0;
        // if (a > 0) {
        //     for (int i = 0; i < a; i++) {
        //         int last_digit = a % 10;
        //         if (last_digit == 1) {
        //             sum_odd += 1;
        //         }
        //         if (last_digit % 2 == 0) {
        //             sum_even += last_digit;
        //         }  else {
        //             sum_odd += last_digit;
        //         }

        //         a /= 10;
        //     }
        // }

        while(a>0){
            int last_digit=a%10;
            if (last_digit%2==0){
                sum_even+=last_digit;
            }
            else{
                sum_odd+=last_digit;
            }
            a/=10;
        }
        System.out.println("The sum of even numbers is: " + sum_even);
        System.out.println("The sum of odd numbers is: " + sum_odd);
    }
}
