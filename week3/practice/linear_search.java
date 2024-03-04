public class linear_search {
    public static int linearSearch(String numbers[],String key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String numbers[]={"Ram","Shyam","Ayush","Kunal","Vinay"};
        String key="Ayush";
        int index=linearSearch(numbers, key);
        if(index==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("The index is: "+index);
        }
    }
}