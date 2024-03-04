public class power_of_two_or_not {
    public static boolean check_power(int n){
        int a=n&(n-1);
        if(a==0){
            return  true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(check_power(10));
    }
}
