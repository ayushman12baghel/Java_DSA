import java.util.*;

// O(n) Using Combinations
class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int mod = 1000000007;

        List<Integer> indexS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                indexS.add(i);
            }
        }

        if (indexS.size() % 2 != 0 || indexS.size() == 0) {
            return 0;
        }

        long result = 1;
        int prev = indexS.get(1);

        for (int i = 2; i < indexS.size(); i += 2) {
            int length = indexS.get(i) - prev;
            result = (result * length) % mod;
            prev = indexS.get(i + 1);
        }

        return (int) result;
    }
}