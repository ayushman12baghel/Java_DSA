public class swap_two_numbers_without_third_variable {
    public static void main(String args[]){
        int x=3, y=4;
        System.out.println("x: "+x+" and y: "+y+" before swap.");
        x^=y;
        y^=x;
        x^=y;
        System.out.println("x: "+x+" and y: "+y+" after swap.");
    }
}
