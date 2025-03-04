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

    public static void main(String args[]) {
        int n = 27;

        System.out.println(isPowerThree(n));
        System.out.println(isPowerThree2(n));
    }
}
