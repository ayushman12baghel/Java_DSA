import java.util.*;
public class print_sum_of_subarrays{
    public static void sum_subarrays(int numbers[]){
        int maximum=Integer.MIN_VALUE;
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=numbers[k];
                    if(maximum<sum){
                        maximum=sum;
                    }
                    if(minimum>sum){
                        minimum=sum;
                    }
                }
                System.out.print(sum);
                System.out.print(" ");
            }
            System.out.println();
        }System.out.println("The maximum is: "+maximum);
        System.out.println("The minimum is: "+minimum);
    }
    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10};
        sum_subarrays(numbers);
    }
}