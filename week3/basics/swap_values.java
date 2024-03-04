public class swap_values {
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;

        System.out.println("a = "+a);
        System.out.println("b = "+b);

    }
    public static void main(String args[]){
        int a=5;
        int b=10;
        swap(a,b);
    }
}
