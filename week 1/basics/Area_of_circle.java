import java.util.*;
public class Area_of_circle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the radius: ");
        int radius=sc.nextInt();
        float area=3.14f*radius*radius;
        System.out.println(area);
    }
}
