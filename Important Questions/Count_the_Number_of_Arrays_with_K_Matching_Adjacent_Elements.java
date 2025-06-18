public class Count_the_Number_of_Arrays_with_K_Matching_Adjacent_Elements {

    static final int mod = 1000000007;

    public static int findPower(int a, int b) {
        long result = 1;
        long base = a % mod;

        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            b /= 2;
        }

        return (int) result;
    }

    public static long nCr(int n, int r, long fact[]) {
        // n! /(n-r! * r!)%mod
        long result = fact[n];
        result = (result * findPower((int) (fact[n - r] % mod), mod - 2)) % mod;
        result = (result * findPower((int) (fact[r] % mod), mod - 2)) % mod;

        return result;
    }

    public static int countGoodArrays(int n, int m, int k) {
        long fact[] = new long[n + 1];
        fact[0] = 1;
        fact[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        long result = nCr(n - 1, k, fact);

        result = (result * m) % mod;
        result = (result * findPower(m - 1, n - k - 1)) % mod;

        return (int) result;
    }

    public static void main(String args[]) {
        int n = 3, m = 2, k = 1;

        System.out.println(countGoodArrays(n, m, k));
    }
}
