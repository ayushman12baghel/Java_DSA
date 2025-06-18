import java.util.*;

public class Binary_Exponentiation {

    // O(log b)
    public static long findPower(int a, int b) {
        if (b == 0) {
            return 1;
        }

        long half = findPower(a, b / 2);
        long result = half * half;

        if (b % 2 != 0) {
            result *= a;
        }

        return result;
    }

    // Iterative Which is more efficient
    static int mod = 1000000007;

    public static long findPower2(int a, int b) {
        long result = 1;
        long base = a % mod;

        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            b /= 2;
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.println(findPower(3, 9));
        System.out.println(findPower2(3, 9));
    }
}
