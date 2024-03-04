public class overloading_using_datatypes {
    public static void sum(int a, int b){
        int sum=a+b;
        System.out.println("sum: "+sum);
    }
    public static void sum(float a, float b){
        float sum=a+b;
        System.out.println("sum: "+sum);
    }
    public static void main(String[] args) {
        int a=5;
        int b=6;
        float c=5;
        float d=6;
        sum(a,b);
        sum(c,d);
    }
}