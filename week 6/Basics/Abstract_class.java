public class Abstract_class {
    public static void main(String args[]){
        // Horse h=new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        // h.changeColor();
        // System.out.println(h.color);
        // Chicken c=new Chicken();
        // c.eat();
        // c.walk();
        // Animal a=new Animal();

        Mustang m=new Mustang();
        //Animal -> Horse -> Mustang
    }
}
abstract class Animal{
    String color;

    Animal(){
        System.out.println("animal constructor called");
    }

    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animal{
    Horse(){
        System.out.println("horse constructor called");
    }
    void changeColor(){
        color="white";
    }
    void walk(){
        System.out.println("walks on four legs");
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang costructor called");
    }
}


class Chicken extends Animal{
    void changeColor(){
        color="yellow";
    }
    void walk(){
        System.out.println("walks on two legs");
    }
}