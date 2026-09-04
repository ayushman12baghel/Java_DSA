// Approach Greedy O(n)
class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int n=arr.size();
        
        int ans=0;
        int sum=0;
        for(int i=0;i<m && i<n;i++){
            sum+=arr.get(i);
        }
        
        if(n<=m){
            return sum;
        }
        
        ans=sum;
        
        for(int i=m;i<m+n;i++){
            sum+=arr.get(i%n);
            sum-=arr.get((i-m+n)%n);
            
            ans=Math.max(sum,ans);
        }
        
        return ans;
    }
}
