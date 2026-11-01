//Approach Brute Force O(n*count)
class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;

        int count=0;
        boolean equal=false;

        while(!equal){
            int maxIndex=0;
            int minIndex=0;

            for(int i=0;i<n;i++){
                if(nums[maxIndex]<nums[i]){
                    maxIndex=i;
                }
                if(nums[minIndex]>nums[i]){
                    minIndex=i;
                }
            }

            if(maxIndex==minIndex){
                equal=true;
                break;
            }

            for(int i=0;i<n;i++){
                if(i!=maxIndex){
                    nums[i]++;
                }
            }

            count++;
        }

        return count;
    }
}

//Approach 2 Optimal O(n)
class Solution {
    public int minMoves(int[] nums) {
        int count=0;

        int minElement=nums[0];
        for(int num:nums){
            minElement=Math.min(num,minElement);
        }

        for(int num:nums){
            count+=num-minElement;
        }

        return count;
    }
}
