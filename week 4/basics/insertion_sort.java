public class insertion_sort {
    public static void insertionSort(int numbers[]){
        for(int i=1;i<numbers.length;i++){
            int curr=numbers[i];
            int prev=i-1;
            // finding out the correct pos to insert
            while(prev>=0 && numbers[prev]>curr){
                numbers[prev+1]=numbers[prev];
                prev--;
            }
            //insertion
            numbers[prev+1]=curr;
        }
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int numbers[]={5,4,1,3,2};
        insertionSort(numbers);
        printArr(numbers);
    }
}
