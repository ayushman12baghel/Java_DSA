import java.util.*;

public class Valid_Palindrome_II {

    public static boolean validPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1);
            }
        }

        return true;
    }

    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String str = "abca";

        System.out.println(validPalindrome(str));
    }
}
