import java.util.*;

public class Valid_Palindrome {

    public static boolean checkPalindrome(String str) {
        if (str.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            char first = str.charAt(start);
            char last = str.charAt(end);

            if (!Character.isLetterOrDigit(first)) {
                start++;
            } else if (!Character.isLetterOrDigit(last)) {
                end--;
            } else {
                if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }

    public static boolean checkPalindrome2(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(checkPalindrome(str));

        System.out.println(checkPalindrome2(str));
    }
}
