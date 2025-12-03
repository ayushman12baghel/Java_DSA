import java.util.*;

//Approach Using Fermats Little Theorem
class Solution {
    static boolean preCompute = false;
    static final long fact[] = new long[100002];
    static final int mod = 1000000007;

    public int countTrapezoids(int[][] points) {
        if (!preCompute) {
            fact();
            preCompute = true;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int point[] : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }

        long prevLines = 0;
        long ans = 0;

        for (int value : map.values()) {
            long currentLine = modularNCR(value, 2) % mod;
            ans = (ans + (prevLines * currentLine) % mod) % mod;
            prevLines += currentLine;
        }

        return (int) (ans % mod);
    }

    public void fact() {
        fact[0] = 1;

        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
    }

    public long modularNCR(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }

        long a = fact[n];
        long b = (fact[r] * fact[n - r]) % mod;

        return (a * findPower(b, mod - 2)) % mod;
    }

    public long findPower(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = findPower(a, b / 2);
        long result = (half * half) % mod;

        if (b % 2 != 0) {
            result = (result * a) % mod;
        }

        return result;
    }
}

// Approach 2
class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1000000007;

        Map<Integer, Integer> map = new HashMap<>();
        for (int point[] : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }

        long prevLines = 0;
        long ans = 0;

        for (int value : map.values()) {
            long currentLine = (1L * value * (value - 1) / 2) % mod;
            ans = (ans + (prevLines * currentLine) % mod) % mod;
            prevLines += currentLine;
        }

        return (int) (ans % mod);
    }
}