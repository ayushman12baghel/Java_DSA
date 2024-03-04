import java.util.*;
public class inbuilt_sort {
    public static void main(String[] args) {
        Integer numbers[]={5,4,1,3,2};
        Arrays.sort(numbers,0,2,Collections.reverseOrder());
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]);
        }
    }
}
