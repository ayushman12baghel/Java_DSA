import java.util.*;
public class find_index_binary {
    public static int find_index(int numbers[],int a){
        int start=0;
        int end=numbers.length-1;
        while (start<=end) {
            int mid=(start+end)/2;
            if(numbers[mid]==a){
                return mid;
            }
            if (numbers[mid]>a) {
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a=sc.nextInt();
        int numbers[]={2,4,6,8,10,12,14,18};
        System.out.println(find_index(numbers,a));
    }
}
