import java.util.*;
public class input_array {
    public static void main(String[] args) {
        int marks[]=new int[100];
        Scanner sc=new Scanner(System.in);
        // int phy;
        // phy=sc.nextInt();
        System.out.print("Enter the phsics marks: ");
        marks[0]=sc.nextInt(); // physics
        System.out.print("Enter the chemistry marks: ");
        marks[1]=sc.nextInt(); //chemistry
        System.out.print("Enter the maths marks: ");
        marks[2]=sc.nextInt(); //math

        System.out.println("phy : " + marks[0]);
        System.out.println("chem : " + marks[1]);
        
        marks[2]+=1;
        System.out.println("math : " + marks[2]);

    }
}
