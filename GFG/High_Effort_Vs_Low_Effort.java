//Approach 1 Using Tabulation O(n)
class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n=h.length;
        
        int dp[]=new int[n];
        dp[0]=Math.max(h[0],l[0]);
        
        for(int i=1;i<n;i++){
            int low=l[i]+dp[i-1];
            
            int high=h[i];
            if(i>=2){
                high+=dp[i-2];
            }
            
            dp[i]=Math.max(high,low);
        }
        
        return dp[n-1];
    }
}

//Approach 2 O(n)
class Solution {
    public int maxTask(int[] h, int[] l) {
        int n=h.length;
        
        int prev=Math.max(h[0],l[0]);
        int doublePrev=0;
        
        for(int i=1;i<n;i++){
            int low=l[i]+prev;
            
            int high=h[i];
            if(i>=2){
                high+=doublePrev;
            }
            doublePrev=prev;
            prev=Math.max(high,low);
        }
        
        return prev;
    }
}
