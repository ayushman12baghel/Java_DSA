public class Palindrome_Number {

    public static boolean isPaindrome(int x) {
        int rev = 0;
        int y = x;
        while (y > 0) {
            int ld = y % 10;
            rev = rev * 10 + ld;
            y /= 10;
        }
        return x == rev;
    }

    public static void main(String args[]) {
        int x = 121;
        System.out.println(isPaindrome(x));
    }
}
