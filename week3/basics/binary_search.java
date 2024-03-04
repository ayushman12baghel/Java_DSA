import java.util.*;
public class binary_search {
    public static int binary_search(int numbers[],int key){
        int start=0;int end=numbers.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(numbers[mid]==key){
                return mid;
            }
            if(numbers[mid]<key){ // right
                start=mid+1;
            }
            else{ // left
                end=mid-1;
            }
        }
            return -1;
    }
        
    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10,12,14,15,16};
        int key=16;

        System.out.println("index for the key is: "+binary_search(numbers, key));
    }
}
