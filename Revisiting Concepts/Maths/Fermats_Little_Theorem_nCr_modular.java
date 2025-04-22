import java.util.*;

public class Fermats_Little_Theorem_nCr_modular {

    static int M = 1000000007;

    public static long modularnCR(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }

        long a = fact(n);
        long b = (fact(r) * fact(n - r)) % M;

        return (a * findPower(b, M - 2)) % M;
    }

    public static long fact(int n) {
        long fact[] = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
        }

        return fact[n];
    }

    public static long findPower(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = findPower(a, b / 2);
        long result = (half * half) % M;

        if (b % 2 != 0) {
            result = (result * a) % M;
        }

        return result;
    }

    public static void main(String args[]) {
        int n = 10;
        int r = 3;

        System.out.println(modularnCR(n, r));
    }
}
