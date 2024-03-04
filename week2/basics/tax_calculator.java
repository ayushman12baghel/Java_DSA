import java.util.*;
public class tax_calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the income in lakhs: ");
        int a=sc.nextInt();
        if(a<=5){
            System.out.print("You have to pay 0% tax");
        }
        else if(a>5 && a<=10){
            System.out.print("You have to pay 20% tax");
        }
        else{
            System.out.print("You have to pay 30% tax");
        }
    }  
}

