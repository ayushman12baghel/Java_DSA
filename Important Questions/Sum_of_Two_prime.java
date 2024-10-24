public class Sum_of_Two_prime {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void isSumOfPrimes(int n) {
        boolean found = false;
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println(i + " " + (n - i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No");
        }
    }

    public static void main(String args[]) {
        int n = 34;
        isSumOfPrimes(n);
    }
}
