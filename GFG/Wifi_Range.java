class Solution {
    public boolean wifiRange(String s, int x) {
        // code here
        int n = s.length();
        int maxReach = -1; 

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (maxReach < i - x - 1) {
                    return false;
                }

                maxReach = Math.max(maxReach, i + x);
            }
        }

        return maxReach >= n - 1;
    }
}
