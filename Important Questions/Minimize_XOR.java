import java.util.*;

public class Minimize_XOR {

    // Approach 1
    public static int minimizeXor(int num1, int num2) {
        int x = num1;
        int count1 = countBit(num1);
        int count2 = countBit(num2);
        int bit = 0;

        if (count1 > count2) {
            while (count1 > count2) {
                if (isSet(x, bit)) {
                    x = clearBit(x, bit);
                    count1--;
                }
                bit++;
            }
        } else if (count1 < count2) {
            while (count1 < count2) {
                if (!isSet(x, bit)) {
                    x = setBit(x, bit);
                    count1++;
                }
                bit++;
            }
        }

        return x;
    }

    public static int countBit(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static boolean isSet(int x, int i) {
        return (x & (1 >> i)) != 0;
    }

    public static int setBit(int x, int i) {
        int bit = 1 << i;

        return (x | bit);
    }

    public static int clearBit(int x, int i) {
        int bit = ~(1 << i);

        return (x & bit);
    }

    // Approach 2
    public static int minimizeXor2(int num1, int num2) {
        int x = 0;
        int required = countBit(num2);

        for (int i = 31; i >= 0 && required > 0; i--) {
            if (isSet(num1, i)) {
                x = setBit(x, i);
                required--;
            }
        }

        for (int i = 0; i < 32 && required > 0; i++) {
            if (!isSet(x, i)) {
                x = setBit(x, i);
                required--;
            }
        }

        return x;
    }

    public static void main(String args[]) {
        int num1 = 1;
        int num2 = 12;

        System.out.println(minimizeXor(num1, num2));
        System.out.println(minimizeXor2(num1, num2));
    }
}
