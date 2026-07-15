//Approach Simulation O(n)
class Solution {
    public int bitonic(int[] nums) {
        int n=nums.length;
        
        int maxLength=1;
        int currentLength=1;
        boolean isIncreasing=true;
        int flatLength=1;
        
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                if(isIncreasing){
                    currentLength++;
                }else{
                    isIncreasing=true;
                    currentLength=flatLength+1;
                }
                
                flatLength=1;
            }else if(nums[i]<nums[i-1]){
                if(isIncreasing){
                    isIncreasing=false;
                    currentLength++;
                }else{
                    currentLength++;
                }
                
                flatLength=1;
            }else{
                flatLength++;
                currentLength++;
            }
            
            maxLength=Math.max(maxLength,currentLength);
        }
        
        return maxLength;
    }
}
