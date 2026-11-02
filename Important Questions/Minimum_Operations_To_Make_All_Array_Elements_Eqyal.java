//Approach Using Binary Search and Prefix Sum O(mlogn)
class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n=nums.length;
        int m=queries.length;

        List<Long> ans=new ArrayList<>();
        Arrays.sort(nums);

        long prefix[]=new long[n];
        prefix[0]=nums[0];

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        for(int i=0;i<m;i++){
            int left=0;
            int right=n;

            while(left<right){
                int mid=left+(right-left)/2;

                if(queries[i]<nums[mid]){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }

            long x=left;

            long leftSum=x*queries[i];
            long leftCost=(leftSum-(x==0?0:prefix[(int)x-1]));

            long rightCost=prefix[n-1]-((n-x)*queries[i])-(x==0?0:prefix[(int)x-1]);

            ans.add(leftCost+rightCost);
        }

        return ans;
    }
}
