class Solution {
    public int smallestSubstring(String s) {
        int freq[] = new int[3];

        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            freq[s.charAt(j) - '0']++;
            if (freq[s.charAt(j) - '0'] == 1) {
                count++;
            }

            if (count == 3) {
                while (freq[s.charAt(i) - '0'] > 1) {
                    freq[s.charAt(i) - '0']--;
                    i++;
                }

                minLength = Math.min(minLength, j - i + 1);
                freq[s.charAt(i) - '0']--;
                i++;
                count--;
            }

            j++;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
};
