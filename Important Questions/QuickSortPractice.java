class QuickSortPractice{

    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;

        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    
    public static void QuickSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pindex=partition(arr,si,ei);
        QuickSort(arr,si,pindex-1);
        QuickSort(arr,pindex+1,ei);
    }

    public static void main(String args[]){
        int arr[]={6,3,9,8,2,5};
        QuickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}