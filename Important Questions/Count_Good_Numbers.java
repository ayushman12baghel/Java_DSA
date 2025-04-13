public class Count_Good_Numbers {

    static int mod = 1000000007;

    public static int countGoodNumbers(long n) {
        return (int) (findPower(5, (n + 1) / 2) * findPower(4, n / 2) % mod);
    }

    public static long findPower(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = findPower(a, b / 2);
        long total = (half * half) % mod;

        if (b % 2 != 0) {
            total = (total * a) % mod;
        }

        return total % mod;
    }

    public static void main(String args[]) {
        int n = 4;

        System.out.println(countGoodNumbers(n));
    }
}
