class Solution {
    public long maxProduct(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        long ans = 1;

        while (n > 4) {
            ans *= 3;
            n -= 3;
        }

        return ans * n;
    }
}
