//Approach Using Prefix and Suffix + Sliding Window O(n) with O(n) space
class Solution {
    public int minSumOfLengths(int[] nums, int target) {
        int n=nums.length;

        int minBefore[]=new int[n];
        int minAfter[]=new int[n];
        Arrays.fill(minBefore,Integer.MAX_VALUE/2);
        Arrays.fill(minAfter,Integer.MAX_VALUE/2);

        int i=0;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE/2;

        while(j<n){
            sum+=nums[j];

            while(sum>target){
                sum-=nums[i];
                i++;
            }

            if(sum==target){
                min=Math.min(min,j-i+1);
            }
            
            minBefore[j]=min;

            j++;
        }

        min=Integer.MAX_VALUE/2;
        sum=0;
        j=n-1;
        i=n-1;

        while(j>=0){
            sum+=nums[j];

            while(sum>target){
                sum-=nums[i];
                i--;
            }

            if(sum==target){
                min=Math.min(min,i-j+1);
            }

            minAfter[j]=min;

            j--;
        }

        int ans=Integer.MAX_VALUE;

        for(i=0;i<n-1;i++){
            ans=Math.min(ans,minBefore[i]+minAfter[i+1]);
        }

        return ans>=Integer.MAX_VALUE/2?-1:ans;
    }
}
