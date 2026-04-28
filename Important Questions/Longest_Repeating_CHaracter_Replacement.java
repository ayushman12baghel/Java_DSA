class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        
        int[] freq = new int[26];
        int i = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        for (int j = 0; j < n; j++) {
            // add current char
            freq[s.charAt(j) - 'A']++;
            
            // update max frequency in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
            
            // if more than k replacements needed → shrink window
            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            
            // update answer
            maxLength = Math.max(maxLength, j - i + 1);
        }
        
        return maxLength;
    }
}
