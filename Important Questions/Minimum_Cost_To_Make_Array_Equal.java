//Approach Using Binary Search O(nlog(max-min))
class Solution {
    public long minCost(int[] nums, int[] cost) {
        long left=nums[0];
        long right=nums[0];

        for(int i=1;i<nums.length;i++){
            left=Math.min(left,nums[i]);
            right=Math.max(right,nums[i]);
        }

        long ans=getCost(nums,cost,left);

        while(left<right){
            long mid=left+(right-left)/2;

            long cost1=getCost(nums,cost,mid);
            long cost2=getCost(nums,cost,mid+1);

            if(cost1>cost2){
                ans=Math.min(ans,cost2);
                left=mid+1;
            }else{
                ans=Math.min(ans,cost1);
                right=mid;
            }
        }

        return ans;
    }

    public long getCost(int nums[],int cost[],long mid){
        long current=0;
        for(int i=0;i<nums.length;i++){
            current+=1L*Math.abs(nums[i]-mid)*cost[i];
        }

        return current;
    }
}
