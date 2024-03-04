import java.util.Scanner;

public class last_occurence {
    // public static int last_occurence(int arr[],int key,int index){
    //     if(index==arr.length){
    //         return -1;
    //     }
    //     int isFound=last_occurence(arr, key, index+1);
    //     if(isFound==-1 && arr[index]==key){
    //         return index;
    //     }
    //     return isFound;
    // }
    public static int last_occurence(int arr[],int key,int index){
        if(index<0){
            return -1;
        }
        if(arr[index]==key){
            return index;
        }
        return last_occurence(arr, key,index-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number to find: ");
        int key=sc.nextInt();
        int arr[]={8,3,6,9,5,10,2,5,7};
        System.out.println(last_occurence(arr,key,arr.length-1));
    }
}
