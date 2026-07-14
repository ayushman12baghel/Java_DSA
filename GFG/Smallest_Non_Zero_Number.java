//Approach Using Binary Search on Ans O(nlogn)
class Solution {
    public int find(int[] nums) {
        int left=1;
        int right=0;
        
        for(int num:nums){
            right=Math.max(right,num);
        }
        
        int result=right;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(isPossible(nums,mid)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return result;
    }
    
    public boolean isPossible(int nums[],long k){
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k){
                k+=(Math.abs(nums[i]-k));
            }else{
                k-=Math.abs(nums[i]-k);
            }
            
            if(k<0){
                return false;
            }
            
            if (k >= 100000) {
                return true;
            }
        }
        
        return k>=0;
    }
}
