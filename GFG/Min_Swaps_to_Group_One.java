class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        
        int ones=0;
        for(int num:nums){
            if(num==1){
                ones++;
            }
        }
        
        if(ones==0){
            return -1;
        }
        
        int currentOne=0;
        int maxOne=0;
        int i=0;
        int j=0;
        
        while(j<n){
            if(nums[j]==1){
                currentOne++;
            }
            
            if(j-i+1>ones){
                currentOne-=nums[i];
                i++;
            }
            
            maxOne=Math.max(maxOne,currentOne);
            j++;
        }
        
        return ones-maxOne;
    }
}
