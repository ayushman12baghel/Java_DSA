class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;

        for (int bit = 0; bit < 32; bit++) {
            long count = 0;

            for (int num : arr) {
                if ((num & (1L << bit)) != 0) {
                    count++;
                }
            }

            long pairs = count * (count - 1) / 2;

  
            ans += pairs * (1L << bit);
        }

        return ans;
    }
}
