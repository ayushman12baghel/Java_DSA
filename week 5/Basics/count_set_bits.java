public class count_set_bits {
    public static int count_set_bits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){// check our lsb
                count++;
            }
           n=n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count_set_bits(10));
        System.out.println(Math.pow(10, 2));
    }
}
