import java.util.*;

public class Palindromic_Substrings {
    // Approach 1
    public static boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static int countSubstring(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkPalindrome(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // Approach 2
    public static int expandFromCentre(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static int countSubstring2(String str) {
        int n = str.length();
        if (n <= 1) {
            return n;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            count += expandFromCentre(str, i, i);
            count += expandFromCentre(str, i, i + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(countSubstring(str));

        System.out.println(countSubstring2(str));
    }
}
