public class GCD_Euclidean_algorithm {

    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    public static void main(String args[]) {
        int x = 4095, y = 7168;

        System.out.println(gcd(x, y));
    }
}
