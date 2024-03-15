import java.util.*;

public class max_subarray_kadane_method {
    public static void kadane(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (cs < 0) {
                cs = 0;
            }
            cs += numbers[i];
            ms = Math.max(cs, ms);

        }
        // if(ms==0){
        // int maximum=Integer.MIN_VALUE;
        // for (int i=0;i<numbers.length;i++){
        // maximum=Math.max(maximum,numbers[i]);
        // }
        System.out.println("The maximum sum is: " + ms);
        // }
        // else{
        // System.out.println("The maximum sum is: "+ms);
        // }
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, -4, -1, -2, -1, -5, -3 };
        kadane(numbers);
    }
}