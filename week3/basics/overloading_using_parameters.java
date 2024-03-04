public class overloading_using_parameters {
    public static void sum(int a, int b){
        int sum=a+b;
        System.out.println("sum: "+sum);
    }
    public static void sum(int a, int b,int c){
        int sum=a+b+c;
        System.out.println("sum: "+sum);
    }
    public static void main(String[] args) {
        int a=5;
        int b=6;
        int c=5;
        sum(a,b);
        sum(a,b,c);
    }
}
