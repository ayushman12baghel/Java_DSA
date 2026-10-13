//Approacg Greedy and Sorting O(nlogn)
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        
        long sum=0;
        int i=nums.length-1;
        int count=(nums.length+1)/2;

        while(i>=0 && count>0){
            sum+=(1L*nums[i]*nums[i]);
            count--;
            i--;
        }

        while(i>=0){
            sum-=(1L*nums[i]*nums[i]);
            i--;
        }

        return sum;
    }
}
