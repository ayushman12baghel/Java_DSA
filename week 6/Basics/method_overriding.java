public class method_overriding {
    public static void main(String args[]){
        Animal a=new Animal();
        Deer b=new Deer();
        a.eat();
        b.eat();
    }
}
class Animal{
    void eat(){
        System.out.println("eats anything");
    }
}
class Deer{
    void eat(){
        System.out.println("eats grass");
    }
}
