//Approach 1 Backtracking O(2^n)
class Solution {
    public int subsetXORSum(int[] nums) {
        int subsets[]=new int[1];
        solve(nums,subsets,0,0);

        return subsets[0];
    }

    public void solve(int nums[],int[] subsets,int i,int temp){
        if(i==nums.length){
            subsets[0]+=temp;
            return;
        }
        solve(nums,subsets,i+1,temp^nums[i]);
        solve(nums,subsets,i+1,temp);
    }
}

//Approach 2 O(n)
class Solution {
    public int subsetXORSum(int[] nums) {
        int totalOr=0;

        for(int num:nums){
            totalOr|=num;
        }

        return totalOr*(1<<(nums.length-1));
    }
}
