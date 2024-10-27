public class Power_of_Three {

    public static boolean isPowerThree(int n) {
        if (n == 1) {
            return true;
        }

        if (n == 0 || n % 3 != 0) {
            return false;
        }

        return isPowerThree(n / 3);
    }

    public static void main(String args[]) {
        int n = 27;

        System.out.println(isPowerThree(n));
    }
}
