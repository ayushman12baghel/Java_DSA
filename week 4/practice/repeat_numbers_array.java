import java.util.*;
public class repeat_numbers_array {
    // public static boolean repeat_number(int numbers[]){
    //     for(int i=0;i<numbers.length;i++){
    //         for(int j=0;j<i;j++){
    //             if(numbers[i]==numbers[j]){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // this was a basic method;


    // this is the Second method;

    // this includes HashSets method for the following approach.

    public static boolean repeat_number(int numbers[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            if(set.contains(numbers[i])){
                return true;
            }
            else{
                set.add(numbers[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int numbers[]={1,2,3,4};
        System.out.println(repeat_number(numbers));
    }
}
