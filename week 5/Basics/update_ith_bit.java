public class update_ith_bit {
    public static int set_ith_bit(int n, int i){
        int bitMask=1<<i;
        return n|bitMask;
    }
    public static int clear_ith_bit(int n,int i){
        int bitMask=~(1<<i);
        return n&bitMask;
    }
    public static int update_ith_bit(int n, int i, int bit){
        // if(bit==0){
        //     return clear_ith_bit(n, i);
        // }
        // else{
        //     return set_ith_bit(n, i);
        // }
        n=clear_ith_bit(n, i);
        int bitMask=(bit<<i);
        return n|bitMask;
    }
    public static void main(String args[]){
        System.out.println(update_ith_bit(10,1,0));
    }
}