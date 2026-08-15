//Approach O(n^2)
class Solution {
    public int longestSubstring(String s, int k) {
        int n=s.length();

        if(n<k){
            return 0;
        }

        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<n;i++){
            if(freq[s.charAt(i)-'a']>0 && freq[s.charAt(i)-'a']<k){
                int left=longestSubstring(s.substring(0,i),k);
                int right=longestSubstring(s.substring(i+1),k);

                return Math.max(left,right);
            }
        }

        return n;
    }
}
