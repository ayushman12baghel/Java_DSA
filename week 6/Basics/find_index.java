import java.util.*;
public class find_index {
    public static int findIndex(int arr[],int key,int index){
        if(index>=arr.length){
            return -1;
        }
        if(key==arr[index]){
            return index;
        }
        return findIndex(arr,key, index+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number to find: ");
        int key=sc.nextInt();
        int arr[]={8,3,6,9,5,10,2,5,7};
        System.out.println(findIndex(arr,key,0));
    }
}
