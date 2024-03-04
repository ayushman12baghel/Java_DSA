// package week 1.practice;
import java.util.*;
public class average_of_numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number:");
        int a=sc.nextInt();
        System.out.println("Enter Second Number:");
        int b=sc.nextInt();
        System.out.println("Enter Third Number:");
        int c=sc.nextInt();
        int sum=(a+b+c)/3;
        System.out.print("The Average of these numbers are:");
        System.out.print(sum);
    }
}
