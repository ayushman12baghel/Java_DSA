import java.util.*;

//Approach 1 O(nlogn) Sorting
class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;

        Arrays.sort(nums);

        int ans=nums[n-3]*nums[n-2]*nums[n-1];
        ans=Math.max(ans,nums[0]*nums[1]*nums[n-1]);

        return ans;
    }
}

//Approach 2 O(n)
class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;

        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(max1<=nums[i]){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }else if(nums[i]>=max2){
                max3=max2;
                max2=nums[i];
            }else if(nums[i]>=max3){
                max3=nums[i];
            }

            if(min1>=nums[i]){
                min2=min1;
                min1=nums[i];
            }else if(min2>=nums[i]){
                min2=nums[i];
            }
        }

        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
