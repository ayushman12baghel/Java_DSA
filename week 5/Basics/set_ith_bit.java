public class set_ith_bit {
    public static int set_ith_bit(int n,int i){
        int bitMask=i<<1;
        return n|bitMask;
    }
    public static void main(String args[]){
        System.out.println(set_ith_bit(10,2));
    }
}
