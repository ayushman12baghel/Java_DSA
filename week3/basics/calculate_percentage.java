import java.util.*;
public class calculate_percentage {
    public static void main(String[] args) {
        int marks[]=new int[3];
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
        System.out.println("math : " + marks[2]);

        int percentage=((marks[0]+marks[1]+marks[2])/3);
        System.out.println("percentage: "+percentage+"%");
        System.out.println("length of an array: "+marks.length);

    }
}
