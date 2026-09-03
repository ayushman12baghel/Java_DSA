//Greedy Approach
class Solution {
    public boolean uniformArray(int[] nums) {
        int oddCount=0;
        int min=nums[0];

        for(int num:nums){
            min=Math.min(min,num);
            if(num%2!=0){
                oddCount++;
            }
        }

        if(min%2!=0){
            return true;
        }

        return oddCount==0;
    }
}
