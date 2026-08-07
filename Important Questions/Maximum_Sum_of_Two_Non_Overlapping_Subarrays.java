//Approach Using Sliding Window O(n)
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n=nums.length;

        int ans=solve(nums,firstLen,secondLen);
        ans=Math.max(ans,solve(nums,secondLen,firstLen));

        return ans;
    }

    public int solve(int nums[],int first,int second){
        int n=nums.length;

        int firstSum=0;
        for(int i=0;i<first;i++){
            firstSum+=nums[i];
        }

        int secondSum=0;
        for(int i=first;i<first+second;i++){
            secondSum+=nums[i];
        }

        int maxFirstSum=firstSum;
        int ans=maxFirstSum+secondSum;

        int i1=0;
        int i2=first-1;
        int j1=first;
        int j2=first+second-1;

        while(j2+1<n){
            firstSum-=nums[i1];
            i1++;i2++;
            firstSum+=nums[i2];

            maxFirstSum=Math.max(maxFirstSum,firstSum);

            secondSum-=nums[j1];
            j1++;
            j2++;
            secondSum+=nums[j2];

            ans=Math.max(ans,maxFirstSum+secondSum);
        }

        return ans;
    }
}
