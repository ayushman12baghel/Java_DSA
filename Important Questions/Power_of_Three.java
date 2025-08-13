public class Power_of_Three {

    // Approach 1 Using Recursion
    public static boolean isPowerThree(int n) {
        if (n == 1) {
            return true;
        }

        if (n == 0 || n % 3 != 0) {
            return false;
        }

        return isPowerThree(n / 3);
    }

    // Approach 2 Using Tabulation
    public static boolean isPowerThree2(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    // Approach 3 O(1) Using log
    public static boolean isPowerOfThree3(int n) {
        if (n <= 0) {
            return false;
        }

        double logValue = Math.log10(n) / Math.log10(3);

        return logValue == (int) logValue;
    }

    public static void main(String args[]) {
        int n = 27;

        System.out.println(isPowerThree(n));
        System.out.println(isPowerThree2(n));
    }
}
