import java.util.*;
public class print_subarrays {
    public static void subarrays(int numbers[]){
        int totalpairs=0;
        for (int i=0;i<numbers.length;i++){
            for (int j=i;j<numbers.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(numbers[k]+" ");
                }
                System.out.print(" ");
                totalpairs++;
            }
            System.out.println();
        }
        System.out.println("The total pairs are: "+totalpairs);
    }
    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10};
        subarrays(numbers);
    }
}
