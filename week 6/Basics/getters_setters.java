public class getters_setters {
    public static void main(String[] args) {
        Pen p1=new Pen();// created a pen object called p1
        p1.setcolor("Blue");
        System.out.println(p1.getcolor());
        p1.settip(5);
        System.out.println(p1.gettip());
        p1.setcolor("Yellow");
        System.out.println(p1.getcolor());
    }
}
class Pen{
    private String color;
    private int tip;

    String getcolor(){
        return this.color;
    }
    int gettip(){
        return this.tip;
    }
    void setcolor(String newcolor){
        this.color=newcolor;
    }
    void settip(int tip){
        this.tip=tip;
    }
}
