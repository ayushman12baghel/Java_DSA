public class clear_ith_bit {
    public static int clear_ith_bit(int n,int i){
        int bitMask=~(1<<i);
        return (n&bitMask);
    }
    public static void main(String[] args) {
        System.out.println(clear_ith_bit(10,1));
    }
}
