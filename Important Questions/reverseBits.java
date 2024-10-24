public class reverseBits {

    public static long reverseBits(int n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(reverseBits(n));
    }
}
