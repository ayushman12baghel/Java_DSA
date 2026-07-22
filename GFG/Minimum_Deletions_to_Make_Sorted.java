//Approach 1 Using Dynamic Programmming O(n^2)  T.L.E
class Solution {
    public int minDeletions(int[] nums) {
        int n=nums.length;
        
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                
                max=Math.max(max,dp[i]);
            }
        }
        
        return n-max;
    }
}

//Approach 2 Using TreeMap LIS O(nlogn)
class Solution {
    public int minDeletions(int[] nums) {
        int n=nums.length;
        
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int max=1;
        
        for(int i=0;i<n;i++){
            Integer key=map.lowerKey(nums[i]);
            
            int length=key==null?1:map.get(key)+1;
            
            if(map.containsKey(nums[i]) && map.get(nums[i])>=length){
                continue;
            }
            
            map.put(nums[i],length);
            max=Math.max(max,length);
            key=map.higherKey(nums[i]);
            while(key!=null && map.get(key)<=length){
                map.remove(key);
                key=map.higherKey(nums[i]);
            }
        }
        
        
        
        return n-max;
    }
}
