import java.util.*;

//O(N · √M)
class Solution {
    public int primePalindrome(int n) {
        if (n <= 2) {
            return 2;
        }

        if (n >= 8 && n <= 11) {
            return 11;
        }

        for (int i = 1; i < 100000; i++) {
            int p = makeOddPalindrome(i);

            if (p >= n && isPrime(p)) {
                return p;
            }
        }

        return -1;
    }

    public int makeOddPalindrome(int n) {
        int palindrome = n;
        n /= 10;

        while (n > 0) {
            int ld = n % 10;
            palindrome = (palindrome * 10) + ld;
            n /= 10;
        }

        return palindrome;
    }

    public boolean isPrime(int n) {
        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}