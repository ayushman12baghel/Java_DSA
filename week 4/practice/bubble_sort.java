public class bubble_sort {
    public static void bubble_sort(int numbers[]){
        for(int i=1;i<numbers.length;i++){
            for(int j=1;j<numbers.length-i;j++){
                if(numbers[j]<numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        for(int i=1;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }
    public static void main(String[] args) {
        int numbers[]={3,6,2,1,8,7,4,5,3,1};
        bubble_sort(numbers);
    }
}
