import java.util.*;

public class Palindromic_Substring_optimised {
    public static int palindromeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }

    public static int checkPalindrome(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int odd = palindromeCount(s, i - 1, i + 1);
            int even = palindromeCount(s, i, i + 1);
            ans += odd + even + 1;
        }
        return ans;
    }

    public static int PalindromicCount(String str) {
        int n = str.length();
        if (n <= 1) {
            return n;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int odd = expandFromCentre(str, i, i);
            int even = expandFromCentre(str, i, i + 1);
            count += odd + even;
        }

        return count;
    }

    public static int expandFromCentre(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(right) == str.charAt(left)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static void main(String args[]) {
        String str = "abc";
        System.out.println(checkPalindrome(str));

        System.out.println(PalindromicCount(str));
    }
}
