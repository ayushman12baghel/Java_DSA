import java.util.*;

public class Shortest_Palindrome {

    // Brute Force O(n2)
    public static String shortestPalindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(0, str.length() - i).equals(reverse.substring(i))) {
                return reverse.substring(0, i) + str;
            }
        }

        return reverse + str;
    }

    // Optimised using KMP Algo O(n)
    public static String shortestPalindrome2(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        String temp = str + '-' + reverse;
        int lps[] = computeLPS(temp);

        int longestLPSLength = lps[lps.length - 1];

        String culprit = reverse.substring(0, str.length() - longestLPSLength);

        return culprit + str;
    }

    public static int[] computeLPS(String pattern) {
        int lps[] = new int[pattern.length()];
        lps[0] = 0;
        int length = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String args[]) {
        String str = "abcd";

        System.out.println(shortestPalindrome(str));
        System.out.println(shortestPalindrome2(str));
    }
}
