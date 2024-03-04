import java.util.*;
public class Largest_number_array {
    public static void largest_number(int numbers[]){
        int a=numbers[0];
        int smallest=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>a){
                a=numbers[i];
            }
            if(smallest>numbers[i]){
                smallest=numbers[i];
            }
        }
        System.out.print("The largest is: "+a+" and smallest: "+smallest);
    }
    public static void main(String[] args) {
        int numbers[]={1,2,6,0,3,5};
        largest_number(numbers);
    }
}
