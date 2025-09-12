import java.util.*;

//O(n) -> Accha Question hai
class Solution {
    static int maxN = 100000;
    static long fact[];
    static long invFact[];
    static int mod = 1000000007;
    static boolean preComputed = false;

    public int countAnagrams(String s) {
        if (!preComputed) {
            precompute(maxN);
            preComputed = true;
        }

        String words[] = s.split(" ");
        long ans = 1;

        for (String word : words) {
            ans = (ans * countWordAnagrams(word)) % mod;
        }

        return (int) ans;
    }

    static void precompute(int maxN) {
        fact = new long[maxN + 1];
        invFact = new long[maxN + 1];

        fact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        invFact[maxN] = modPow(fact[maxN], mod - 2) % mod;// Yaha maine inverse fact[maxN] find kiya last bale ke lie
                                                          // (fermat's Littile Theorem)

        for (int i = maxN; i > 0; i--) {
            invFact[i - 1] = (invFact[i] * i) % mod; // then yaha maine peeche ke nikale
        }
    }

    static long modPow(long a, long b) { // ye binary Exponentiation bala code (for fermat lettle therome nCr
                                         // modPow(a,mod-2) -> to find inverse exponentioation of a^-1)
        if (b == 0) {
            return 1;
        }

        long half = modPow(a, b / 2);
        long result = (half * half) % mod;
        if (b % 2 != 0) {
            result = (result * a) % mod;
        }

        return result;
    }

    public long countWordAnagrams(String word) {
        int length = word.length();
        int freq[] = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        long ans = fact[length];

        for (int num : freq) {
            if (num > 0) {
                ans = (ans * invFact[num]) % mod;
            }
        }

        return ans;
    }
}