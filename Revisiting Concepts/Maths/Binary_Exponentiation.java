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

    public static void main(String args[]) {
        System.out.println(findPower(3, 9));
    }
}
