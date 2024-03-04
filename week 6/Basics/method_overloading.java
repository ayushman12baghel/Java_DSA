public class method_overloading {
    public static void main(String args[]){
        Calculator c1=new Calculator();
        System.out.println(c1.sum(4,5));
        System.out.println(c1.sum((float)4.5,(float)5.5));
        System.out.println(c1.sum(4,5,5));
    }
}
class Calculator{
    int sum(int a, int b){
        return a+b;
    }
    float sum(float a, float b){
        return a+b;
    }
    int sum(int a, int b,int c){
        return a+b+c;
    }
}
