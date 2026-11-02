//Approach Using Binary Search on Ans O(nlogn)
class Solution {
    public int minMoves2(int[] nums) {
        int left=nums[0];
        int right=nums[0];

        for(int num:nums){
            left=Math.min(left,num);
            right=Math.max(right,num);
        }

        while(left<right){
            int mid=left+(right-left)/2;
            int count=getCount(nums,mid);
            int count2=getCount(nums,mid+1);

            if(count>count2){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        return getCount(nums,left);
    }

    public int getCount(int nums[],int mid){
        int count=0;

        for(int num:nums){
            count+=Math.abs(num-mid);
        }

        return count;
    }
}
